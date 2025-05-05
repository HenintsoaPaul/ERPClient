package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.pinvoice.PurchaseInvoiceItemResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseInvoiceItemService {

    private final ApiClient apiClient;

    public PurchaseInvoiceItemResponse findAllBySupplier(String name) {
        try {
            String uri = UriComponentsBuilder
                    .fromPath("/api/method/erpnext.api.get_full_purchase_invoice")
                    .queryParam("name", name)
                    .toUriString();

            return apiClient.executeGet(
                    uri,
                    PurchaseInvoiceItemResponse.class
            );
        } catch (RestClientException e) {
            log.error("Failed to fetch purchase invoice items for {}", name, e);
            throw new ApiClientException("purchase.invoice.item.fetch.error", e);
        }
    }
}
