package com.erp.erpclient.controller.api;

import com.erp.erpclient.dto.LbMemberResponse;
import com.erp.erpclient.service.api.LbMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lb/member")
@RequiredArgsConstructor
public class LbMemberController {

    private final LbMemberService lbMemberService;

    @GetMapping
    public ResponseEntity<LbMemberResponse> getAll() {
        return ResponseEntity.ok(lbMemberService.getTempRows());
    }
}
