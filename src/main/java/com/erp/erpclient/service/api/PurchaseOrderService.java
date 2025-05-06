package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.porder.PurchaseOrderResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseOrderService {

    private final ApiClient apiClient;

    public PurchaseOrderResponse findAllBySupplier(String supplierName) {
        try {
            String uri = UriComponentsBuilder
                    .fromPath("/api/method/erpnext.api.get_purchase_orders")
                    .queryParam("supplier_name", supplierName)
                    .build()
                    .toUriString();

            return apiClient.executeGet(uri, PurchaseOrderResponse.class);
        } catch (RestClientException e) {
            log.error("Failed to fetch purchase invoices for {}", supplierName, e);
            throw new ApiClientException("purchase.invoice.fetch.error", e);
        }
    }
}
