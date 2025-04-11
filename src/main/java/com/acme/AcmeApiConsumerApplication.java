package com.acme;

import com.acme.getparcelshops.ParcelShopService;
import com.acme.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AcmeApiConsumerApplication {

	@Autowired
	public LoginService loginService;
	@Autowired
	public ParcelShopService parcelShopService;

	public static void main(String[] args) {
		SpringApplication.run(AcmeApiConsumerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String token = loginService.saveLogin();
			parcelShopService.saveParcelShops(token);
		};
	}
}
