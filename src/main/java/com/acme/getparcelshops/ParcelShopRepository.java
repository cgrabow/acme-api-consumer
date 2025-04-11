package com.acme.getparcelshops;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParcelShopRepository extends MongoRepository<ParcelShop, String> {
}
