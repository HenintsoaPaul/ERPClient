package com.erp.erpclient.service.api;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.dto.pinvoice.PurchaseInvoiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseInvoiceService {

    private final RestClient restClient;
    private final SessionManager sessionManager;

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
}
