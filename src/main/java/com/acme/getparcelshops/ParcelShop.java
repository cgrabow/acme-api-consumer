package com.acme.getparcelshops;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParcelShop {

    private String id;
    private String name;
    private String type;
    private Double latitude;
    private Double longitude;
    private String carrier;
    private String addressLine1;
    private String postCode;
    private String city;
    private String country;
    private List<OpeningTime> openingTimes;
    private String carrierData;
}
