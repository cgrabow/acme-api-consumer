package com.acme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate loginApi(RestTemplateBuilder builder, @Value("${login.api.url}") String path) {
        return builder.rootUri(path).build();
    }
    @Bean
    public RestTemplate parcelApi(RestTemplateBuilder builder, @Value("${getparcelshop.api.url}") String path) {
        return builder.rootUri(path).build();
    }
}
