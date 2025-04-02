package com.acme.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class LoginService {

    @Autowired
    public LoginRepository loginRepository;
    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${login.api.url}")
    private String baseUrl;

    public LoginResponse getLogin(@RequestBody LoginRequest loginRequest) {
        return restTemplate.postForObject(baseUrl, loginRequest, LoginResponse.class);
    }

    public void saveLogin() {
        try {
            var response = getLogin(LoginRequest.builder()
                    .username("assignment-test@ubsend.com")
                    .password("p0DrmE)E+BQH$]KasMSb")
                    .build());
            loginRepository.save(response);
        } catch (Exception e) {
            log.error("Error while saving login response: {}", e.getMessage());
        }
    }
}