package com.erp.erpclient.controller.api;

import com.erp.erpclient.dto.LoginRequest;
import com.erp.erpclient.dto.LoginResponse;
import com.erp.erpclient.service.api.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> createData(
            @RequestBody LoginRequest loginRequest
    ) {
        return ResponseEntity.ok(loginService.login(loginRequest));
    }

}
