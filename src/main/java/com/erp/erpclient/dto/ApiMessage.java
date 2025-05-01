package com.erp.erpclient.dto;

import java.util.List;

public record ApiMessage<T>(
        boolean success,
        List<T> data,
        int count
) {}