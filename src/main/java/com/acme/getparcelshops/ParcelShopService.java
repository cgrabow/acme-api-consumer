package com.acme.getparcelshops;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@Service
public class ParcelShopService {
    private final ParcelShopRepository parcelShopRepository;
    private final RestTemplate parcelApi;

    @Autowired
    public ParcelShopService(ParcelShopRepository parcelShopRepository, RestTemplate parcelApi) {
        this.parcelShopRepository = parcelShopRepository;
        this.parcelApi = parcelApi;
    }

    public List<ParcelShop> getParcelShops(String token, String carrier, String country, String limit) {
        String urlTemplate = UriComponentsBuilder.fromPath("/parcel-shops")
                .queryParam("carrier", carrier)
                .queryParam("country", country)
                .queryParam("limit", limit)
                .toUriString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        return parcelApi.exchange(urlTemplate,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                new ParameterizedTypeReference<List<ParcelShop>>() {
        }).getBody();
    }

    public void saveParcelShops(String token) {
        try {
            var response = getParcelShops(token, "CORREOS", "ES", "10");
            parcelShopRepository.saveAll(response);
        } catch (Exception e) {
            log.error("Error while saving parcel shops: {}", e.getMessage());
        }
    }
}
