package com.erp.erpclient.service.api;

import com.erp.erpclient.dto.LbMemberResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class LbMemberService {

    private final RestClient restClient;

    public LbMemberService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://library.localhost:8000")
                .messageConverters(converters -> {
                    converters.clear();
                    converters.add(new MappingJackson2HttpMessageConverter());
                })
                .build();
    }

    public LbMemberResponse getTempRows() {
        return restClient.get()
                .uri("/api/method/erpnext.api.get_lb_members_temp")
                .accept(MediaType.APPLICATION_JSON, MediaType.valueOf("application/*+json"))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", "token 5cd092b581e453b:852f1cf124a9687")
                .retrieve()
                .body(LbMemberResponse.class);
    }
}
