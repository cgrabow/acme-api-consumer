package com.acme.getparcelshops;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ParcelShopService {

    @Autowired
    private ParcelShopRepository parcelShopRepository;
    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${getparcelshop.api.url}")
    private String baseUrl;

    public ParcelShopResponse getParcelShops(@RequestHeader("Authorization") String token, @RequestParam(name = "carrier") String carrier, @RequestParam(name = "country") String country, @RequestParam(name = "limit") String limit) {
        return restTemplate.getForObject(baseUrl, ParcelShopResponse.class, token, carrier, country, limit);
    }

    public void saveParcelShops(@RequestHeader("Authorization") String token) {
        try {
            var response = getParcelShops(token, "CORREOS", "ES", "10");
            parcelShopRepository.save(response);
        } catch (Exception e) {
            log.error("Error while saving parcel shops: {}", e.getMessage());
        }
    }
}
