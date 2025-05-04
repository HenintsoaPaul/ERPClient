package com.erp.erpclient.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;

import java.util.List;

@Configuration
public class RestClientConfig {

    @Value(value = "${frappe.base.url}")
    private String frappeBaseUrl;

    @Bean
    public RestClient restClient() {
        // Configure Jackson to use snake_case for JSON keys
        ObjectMapper mapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        // localDateTime issue
        mapper.registerModule(new JavaTimeModule());

        // Custom message converter with the configured ObjectMapper
        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter(mapper);
        converter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON));

        // Build the RestClient with global settings
        return RestClient.builder()
                .baseUrl(this.frappeBaseUrl)
                .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
                .messageConverters(converters -> {
                    converters.add(0, new StringHttpMessageConverter());
                    converters.add(1, converter);
                })
                .build();
    }
}
