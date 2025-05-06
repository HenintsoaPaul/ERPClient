package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.SupplierResponse;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierService {

    private final ApiClient apiClient;

    public SupplierResponse findAll() {
        try {
            String uri = "/api/method/erpnext.api.get_suppliers";

            return apiClient.executeGet(uri, SupplierResponse.class);
        } catch (RestClientException e) {
            log.error("Failed to fetch suppliers", e);
            throw new ApiClientException("supplier.quotation.fetch.error", e);
        }
    }
}
