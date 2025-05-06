package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.porder.PurchaseOrderItemResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseOrderItemService {

    private final ApiClient apiClient;

    public PurchaseOrderItemResponse findAllBySupplier(String supplierName) {
        try {
            String uri = UriComponentsBuilder
                    .fromPath("/api/method/erpnext.api.get_full_purchase_order")
                    .queryParam("name", supplierName)
                    .build()
                    .toUriString();

            return apiClient.executeGet(uri, PurchaseOrderItemResponse.class);
        } catch (RestClientException e) {
            log.error("Failed to fetch purchase order items for {}", supplierName, e);
            throw new ApiClientException("purchase.order.item.fetch.error", e);
        }
    }
}
