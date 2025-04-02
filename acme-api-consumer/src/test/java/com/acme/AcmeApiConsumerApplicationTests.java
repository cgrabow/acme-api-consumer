package com.acme;

import com.acme.getparcelshops.ParcelShopService;
import com.acme.login.LoginRepository;
import com.acme.login.LoginResponse;
import com.acme.login.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class AcmeApiConsumerApplicationTests {

    @Autowired
    private AcmeApiConsumerApplication application;

    private LoginService loginService;

    private ParcelShopService parcelShopService;

    private LoginRepository loginRepository;

    @Test
    void contextLoads() {
        // Test to ensure the Spring context loads successfully
    }

    @Test
    void testCommandLineRunner() throws Exception {
        // Arrange
        var loginResponse = new LoginResponse();
        loginResponse.setAccessToken("test-token");
        when(loginRepository.findByUsername("assignment-test@ubsend.com")).thenReturn(loginResponse);

        // Act
        application.commandLineRunner().run();

        // Assert
        verify(loginService).saveLogin();
        verify(parcelShopService).saveParcelShops("test-token");
    }
}