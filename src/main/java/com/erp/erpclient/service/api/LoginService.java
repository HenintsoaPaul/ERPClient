package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.LoginRequest;
import com.erp.erpclient.dto.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
@Slf4j
public class LoginService {

    private final RestClient restClient;

    public LoginService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://library.localhost:8000")
                .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public LoginResponse login(LoginRequest request) {
        try {
            return this.restClient.post()
                    .uri("/api/method/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        throw new RuntimeException("Client error: " + res.getStatusText());
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        throw new RuntimeException("Server error: " + res.getStatusText());
                    })
                    .body(LoginResponse.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }
}
