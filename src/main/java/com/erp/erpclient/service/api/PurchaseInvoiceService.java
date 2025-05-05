package com.erp.erpclient.service.api;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.dto.pinvoice.PurchaseInvoiceResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseInvoiceService {

    private final RestClient restClient;
    private final SessionManager sessionManager;
    private final RestTemplate restTemplate = new RestTemplate();

    public PurchaseInvoiceResponse findAllBySupplier(String supplier) {
        try {
            String sessionCookie = sessionManager.getAuthCookie();

            RestClient.ResponseSpec responseSpec = this.restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/method/erpnext.api.get_purchase_invoices")
                            .queryParam("supplier_name", supplier)
                            .build()
                    )
                    .header(HttpHeaders.COOKIE, sessionCookie)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve();

            return responseSpec
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        String body = res.getBody().toString();
                        throw new RuntimeException("API client error: " + res.getStatusCode() + " - " + body);
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        String body = res.getBody().toString();
                        throw new RuntimeException("API server error: " + res.getStatusCode() + " - " + body);
                    })
                    .body(PurchaseInvoiceResponse.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }

    public String addPayment(String purchaseInvoiceId, double amount, String postingDate) {
        try {
            String sessionCookie = sessionManager.getAuthCookie();

            RestClient.ResponseSpec responseSpec = this.restClient.get()
                    .uri(uriBuilder -> uriBuilder
//                            .path("/api/method/erpnext.api.create_payment_for_invoice_2")
                            .path("/api/method/erpnext.api.create_payment_for_invoice")
                            .queryParam("purchase_invoice_id", purchaseInvoiceId)
                            .queryParam("amount", amount)
                            .queryParam("posting_date", postingDate)
                            .build()
                    )
                    .header(HttpHeaders.COOKIE, sessionCookie)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve();

            return responseSpec
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        String body = res.getBody().toString();
                        throw new RuntimeException("API client error: " + res.getStatusCode() + " - " + body);
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        String body = res.getBody().toString();
                        throw new RuntimeException("API server error: " + res.getStatusCode() + " - " + body);
                    })
                    .body(String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }

    public boolean makePayment(String invoiceReference, double paymentAmount, String paymentDate,
                               String paymentMethod, String paymentReference, String paymentRemarks,
                               HttpSession session) {
        try {
            HttpHeaders headers = new HttpHeaders();
            // Ajoute le cookie SID aux en-têtes pour l'authentification
//            addSidToHeaders(headers, session);
            headers.add("Cookie", sessionManager.getAuthCookie());

            headers.setContentType(MediaType.APPLICATION_JSON);

            // Étape 1: Générer un brouillon de paiement à partir de la facture
            Map<String, Object> requestData = new HashMap<>();
            requestData.put("dt", "Purchase Invoice");  // Type de document (facture d'achat)
            requestData.put("dn", invoiceReference);    // Nom du document (référence de la facture)

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestData, headers);

            // URL pour appeler la méthode de génération de paiement
            String url = "http://erpnext.localhost:8001/api/method/erpnext.accounts.doctype.payment_entry.payment_entry.get_payment_entry";

            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );

            if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
                System.err.println("Erreur lors de la génération du brouillon de paiement");
                return false;
            }

            // Étape 2: Récupérer le brouillon de paiement généré
            Map<String, Object> responseData = response.getBody();
            if (!responseData.containsKey("message")) {
                System.err.println("Réponse invalide lors de la génération du brouillon de paiement");
                return false;
            }

            Map<String, Object> paymentEntry = (Map<String, Object>) responseData.get("message");

            // Étape 3: Modifier le brouillon de paiement selon les besoins
            if (paymentMethod != null && !paymentMethod.isEmpty()) {
                paymentEntry.put("mode_of_payment", paymentMethod);
            }

            if (paymentDate != null && !paymentDate.isEmpty()) {
                paymentEntry.put("posting_date", paymentDate);
            }

            // Ajouter les informations obligatoires pour les transactions bancaires
            // Si paymentReference est null ou vide, générer une référence par défaut
            String referenceNo = (paymentReference != null && !paymentReference.trim().isEmpty())
                    ? paymentReference
                    : "REF-" + System.currentTimeMillis();

            paymentEntry.put("reference_no", referenceNo);
            paymentEntry.put("reference_date", paymentDate); // Utiliser la même date que la date de paiement

            if (paymentRemarks != null && !paymentRemarks.isEmpty()) {
                paymentEntry.put("remarks", paymentRemarks);
            }

            // Si le montant du paiement est différent du montant total de la facture
            if (paymentAmount > 0) {
                paymentEntry.put("paid_amount", paymentAmount);
                paymentEntry.put("received_amount", paymentAmount);

                // Mettre à jour le montant alloué dans les références
                if (paymentEntry.containsKey("references")) {
                    List<Map<String, Object>> references = (List<Map<String, Object>>) paymentEntry.get("references");
                    if (references != null && !references.isEmpty()) {
                        references.get(0).put("allocated_amount", paymentAmount);
                    }
                }
            }

            // Étape 4: Soumettre le paiement
            Map<String, Object> submitData = new HashMap<>();
            submitData.put("doc", paymentEntry);

            HttpEntity<Map<String, Object>> submitEntity = new HttpEntity<>(submitData, headers);

            // URL pour soumettre le document
            String submitUrl = "http://erpnext.localhost:8001/api/method/frappe.client.submit";

            ResponseEntity<Map> submitResponse = restTemplate.exchange(
                    submitUrl,
                    HttpMethod.POST,
                    submitEntity,
                    Map.class
            );

            return submitResponse.getStatusCode().is2xxSuccessful();
        } catch (RestClientException e) {
            System.err.println("Erreur lors de l'enregistrement du paiement: " + e.getMessage());
            return false;
        }
    }

}
