package com.erp.erpclient.service.api;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.dto.SupplierQuotationResponse;
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
public class SupplierQuotationService {

    private final RestClient restClient;
    private final SessionManager sessionManager;

    public SupplierQuotationResponse findAllBySupplier(String supplierName) {
        try {
            String sessionCookie = sessionManager.getAuthCookie();

            RestClient.ResponseSpec responseSpec = this.restClient.get()
//                    .uri("api/method/library_management.api.get_supplier_quotations")
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/method/library_management.api.get_supplier_quotations")  // Existing path
                            .queryParam("supplier_name", supplierName)    // Add query param
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
                    .body(SupplierQuotationResponse.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }
}
