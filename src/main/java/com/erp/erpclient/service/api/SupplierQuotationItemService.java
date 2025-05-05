package com.erp.erpclient.service.api;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.dto.SupplierQuotationItemResponse;
import com.erp.erpclient.entity.supplierquotation.SupplierQuotationItem;
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
public class SupplierQuotationItemService {

    private final RestClient restClient;
    private final SessionManager sessionManager;

    public SupplierQuotationItemResponse findAllBySupplier(String name) {
        try {
            String sessionCookie = sessionManager.getAuthCookie();

            RestClient.ResponseSpec responseSpec = this.restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/method/erpnext.api.get_full_supplier_quotation")
                            .queryParam("name", name)
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
                    .body(SupplierQuotationItemResponse.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }

    private record UpdateRateResponse(SupplierQuotationItem data) {
    }

    private record UpdateRateRequest(double rate, double qty) {
    }

    public SupplierQuotationItem updateRate(String itemId, Double newRate, Double newQty) {
        try {
            String sessionCookie = sessionManager.getAuthCookie(),
                    uri = "/api/resource/Supplier Quotation Item/" + itemId;

            RestClient.ResponseSpec responseSpec = this.restClient.put()
                    .uri(uri)
                    .header(HttpHeaders.COOKIE, sessionCookie)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(new UpdateRateRequest(newRate, newQty))
                    .retrieve();

            UpdateRateResponse response = responseSpec
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        String body = res.getBody().toString();
                        throw new RuntimeException("API client error: " + res.getStatusCode() + " - " + body);
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        String body = res.getBody().toString();
                        throw new RuntimeException("API server error: " + res.getStatusCode() + " - " + body);
                    })
                    .body(UpdateRateResponse.class);

            return response.data();
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }
}
