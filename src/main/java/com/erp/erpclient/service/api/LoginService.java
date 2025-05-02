package com.erp.erpclient.service.api;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.dto.LoginRequest;
import com.erp.erpclient.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final RestClient restClient;
    private final SessionManager sessionManager;

    public LoginResponse login(LoginRequest request) {
        try {
            ResponseEntity<LoginResponse> responseEntity = this.restClient.post()
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
                    .toEntity(LoginResponse.class);

            // Get all cookies from the response
            HttpHeaders headers = responseEntity.getHeaders();
            List<String> cookieHeaders = headers.get(HttpHeaders.SET_COOKIE);

            // If you need a specific cookie
            assert cookieHeaders != null;
            String sessionCookie = cookieHeaders.stream()
                    .filter(c -> c.startsWith("sid=")) // replace with your cookie name
                    .findFirst()
                    .orElse(null);

            sessionManager.setAuthCookie(sessionCookie);

            return responseEntity.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }
}
