package com.erp.erpclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LbMember(
        String name,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("email_propla") String email,
        int transferred
) {}