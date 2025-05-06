package com.erp.erpclient.service.api;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.exception.ApiClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiClient {

    private final RestClient restClient;
    private final SessionManager sessionManager;

    public <T> T executeGet(String uri, Class<T> responseType) {
        return executeRequest(HttpMethod.GET, uri, null, responseType);
    }

    public <T> T executePut(String uri, Object body, Class<T> responseType) {
        return executeRequest(HttpMethod.PUT, uri, body, responseType);
    }

    public <T> T executePost(String uri, Object body, Class<T> responseType) {
        return executeRequest(HttpMethod.POST, uri, body, responseType);
    }

    private <T> T executeRequest(HttpMethod method, String uri, Object body, Class<T> responseType) {
        try {
            RestClient.RequestBodySpec requestSpec = restClient.method(method)
                    .uri(uri)
                    .headers(this::addCommonHeaders);

            if (body != null) {
                requestSpec.contentType(MediaType.APPLICATION_JSON).body(body);
            }

            return requestSpec
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        throw new RuntimeException("API client error: " + res.getStatusCode() + " - " + res.getBody());
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        throw new RuntimeException("API server error: " + res.getStatusCode() + " - " + res.getBody());
                    })
                    .body(responseType);
        } catch (RestClientException e) {
            log.error("API call failed for {} {}", method, uri, e);
            throw new ApiClientException("api.call.failed", e);
        }
    }

    private void addCommonHeaders(HttpHeaders headers) {
        headers.add(HttpHeaders.COOKIE, sessionManager.getAuthCookie());
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    }
}