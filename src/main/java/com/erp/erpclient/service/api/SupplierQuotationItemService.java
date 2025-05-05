package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.SupplierQuotationItemResponse;
import com.erp.erpclient.entity.supplierquotation.UpdateResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class SupplierQuotationItemService {

    private static final String SUPPLIER_QUOTATION_ITEM_PATH = "/api/resource/Supplier Quotation Item/";
    private static final String GET_QUOTATION_METHOD_PATH = "/api/method/erpnext.api.get_full_supplier_quotation";

    private final ApiClient apiClient;

    public SupplierQuotationItemResponse findAllBySupplier(String supplierName) {
        try {
            String uri = UriComponentsBuilder
                    .fromPath(GET_QUOTATION_METHOD_PATH)
                    .queryParam("name", supplierName)
                    .toUriString();

            return apiClient.executeGet(
                    uri,
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

            return apiClient.executePut(
                    SUPPLIER_QUOTATION_ITEM_PATH + itemId,
                    requestBody,
                    UpdateResponse.class
            );
        } catch (RestClientException e) {
            log.error("Failed to update rate for item {}", itemId, e);
            throw new ApiClientException("supplier.quotation.rate.update.error", e);
        }
    }
}