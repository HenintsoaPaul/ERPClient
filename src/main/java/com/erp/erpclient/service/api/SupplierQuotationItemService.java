package com.erp.erpclient.service.api;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.dto.SupplierQuotationItemResponse;
import com.erp.erpclient.entity.supplierquotation.UpdateResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class SupplierQuotationItemService {

    private static final String SUPPLIER_QUOTATION_ITEM_PATH = "/api/resource/Supplier Quotation Item/";
    private static final String GET_QUOTATION_METHOD_PATH = "/api/method/erpnext.api.get_full_supplier_quotation";

    private final RestClient restClient;
    private final SessionManager sessionManager;

    public SupplierQuotationItemResponse findAllBySupplier(String supplierName) {
        try {
            return executeAuthenticatedGet(
                    UriComponentsBuilder.fromPath(GET_QUOTATION_METHOD_PATH)
                            .queryParam("name", supplierName)
                            .toUriString(),
                    SupplierQuotationItemResponse.class
            );
        } catch (RestClientException e) {
            log.error("Failed to fetch supplier quotations for {}", supplierName, e);
            throw new ApiClientException("supplier.quotation.fetch.error", e);
        }
    }

    public UpdateResponse updateRate(String itemId, Double newRate, Double newQty) {
        try {
            Map<String, Object> requestBody = Map.of(
                    "rate", newRate,
                    "qty", newQty
            );

            return executeAuthenticatedPut(
                    SUPPLIER_QUOTATION_ITEM_PATH + itemId,
                    requestBody,
                    UpdateResponse.class
            );
        } catch (RestClientException e) {
            log.error("Failed to update rate for item {}", itemId, e);
            throw new ApiClientException("supplier.quotation.rate.update.error", e);
        }
    }

    private <T> T executeAuthenticatedGet(String uri, Class<T> responseType) {
        return restClient.get()
                .uri(uri)
                .headers(this::addAuthHeaders)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                    throw new RuntimeException("API client error: " + res.getStatusCode() + " - " + res.getBody());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                    throw new RuntimeException("API server error: " + res.getStatusCode() + " - " + res.getBody());
                })
                .body(responseType);
    }

    private <T> T executeAuthenticatedPut(String uri, Object body, Class<T> responseType) {
        return restClient.put()
                .uri(uri)
                .headers(this::addAuthHeaders)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                    throw new RuntimeException("API client error: " + res.getStatusCode() + " - " + res.getBody().toString());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                    throw new RuntimeException("API server error: " + res.getStatusCode() + " - " + res.getBody().toString());
                })
                .body(responseType);
    }

    private void addAuthHeaders(HttpHeaders headers) {
        headers.add(HttpHeaders.COOKIE, sessionManager.getAuthCookie());
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    }
}