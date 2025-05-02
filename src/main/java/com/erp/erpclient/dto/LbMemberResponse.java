package com.erp.erpclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LbMemberResponse(
        @JsonProperty("message") ApiMessage<LbMember> apiMessage
) {}

/*
*     "message": {
        "success": true,
        "data": [
            {
                "name": "556",
                "first_name": "youngjosh",
                "email_propla": "youngjosh@gmail.com",
                "transferred": 1
            }
        ],
        "count": 2
    }
* */