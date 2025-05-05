package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.pinvoice.PurchaseInvoiceResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseInvoiceService {

    private final ApiClient apiClient;

    public PurchaseInvoiceResponse findAllBySupplier(String supplierName) {
        try {
            String uri = UriComponentsBuilder
                    .fromPath("/api/method/erpnext.api.get_purchase_invoices")
                    .queryParam("supplier_name", supplierName)
                    .build()
                    .toUriString();

            return apiClient.executeGet(uri, PurchaseInvoiceResponse.class);
        } catch (RestClientException e) {
            log.error("Failed to fetch purchase invoices for {}", supplierName, e);
            throw new ApiClientException("purchase.invoice.fetch.error", e);
        }
    }

    public String addPayment(String purchaseInvoiceId,
                             double paymentAmount,
                             String paymentDate,
                             String paymentMethod,
                             String paymentRemarks) {
        try {
            // Step 1: Generate draft
            Map<String, Object> requestData = new HashMap<>();
            requestData.put("dt", "Purchase Invoice");
            requestData.put("dn", purchaseInvoiceId);

            Map<String, Map<String, Object>> responseData = apiClient.executePost(
                    "/api/method/erpnext.accounts.doctype.payment_entry.payment_entry.get_payment_entry",
                    requestData,
                    Map.class
            );

            // Step 2: Get generated draft
            if (!responseData.containsKey("message")) {
                String err = "Réponse invalide lors de la génération du brouillon de paiement";
                log.error(err);
                throw new RuntimeException(err);
            }

            // Step 3: Set paymentEntry fields
            Map<String, Object> paymentEntry = setup(
                    paymentMethod,
                    paymentDate,
                    paymentRemarks,
                    paymentAmount,
                    responseData
            );

            // Step 4: Submit
            Map<String, Object> submitData = new HashMap<>();
            submitData.put("doc", paymentEntry);

            Map<String, Object> submitResponse = apiClient.executePost(
                    "/api/method/frappe.client.submit",
                    submitData,
                    Map.class
            );

            return "ok";
        } catch (RestClientException e) {
            log.error("Failed to add payment entry for {}", purchaseInvoiceId, e);
            throw new ApiClientException("payment.entry.add.error", e);
        }
    }

    private Map<String, Object> setup(String paymentMethod, String paymentDate, String paymentRemarks, double paymentAmount, Map<String, Map<String, Object>> responseData) {
        Map<String, Object> paymentEntry = responseData.get("message");

        if (paymentMethod != null && !paymentMethod.isEmpty()) {
            paymentEntry.put("mode_of_payment", paymentMethod);
        }
        if (paymentDate != null && !paymentDate.isEmpty()) {
            paymentEntry.put("posting_date", paymentDate);
        }

        paymentEntry.put("reference_no", "REF-" + System.currentTimeMillis());
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

        return paymentEntry;
    }

}
