package com.acme.login;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface LoginRepository extends MongoRepository<LoginResponse, LoginResponse> {
    LoginResponse findByUsername(String username);

}
