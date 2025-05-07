package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.SupplierQuotationResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierQuotationService {

    private final ApiClient apiClient;

    private static final String SUPPLIER_QUOTATION_PATH = "/api/resource/Supplier Quotation/";

    public SupplierQuotationResponse findAllBySupplier(String supplierName) {
        try {
            String uri = UriComponentsBuilder
                    .fromPath("/api/method/erpnext.api.get_supplier_quotations")
                    .queryParam("supplier_name", supplierName)
                    .build()
                    .toUriString();

            return apiClient.executeGet(uri, SupplierQuotationResponse.class);
        } catch (RestClientException e) {
            log.error("Failed to fetch supplier quotation for {}", supplierName, e);
            throw new ApiClientException("supplier.quotation.fetch.error", e);
        }
    }

    public void submitByName(String name) {
        try {
            Map<String, Object> requestBody = Map.of(
                    "status", "Submitted"
            );

            apiClient.executePut(
                    SUPPLIER_QUOTATION_PATH + name,
                    requestBody,
                    Object.class
            );
        } catch (RestClientException e) {
            log.error("Failed to submit supplier quotation {}", name, e);
            throw new ApiClientException("supplier.quotation.submit.error", e);
        }
    }

}
