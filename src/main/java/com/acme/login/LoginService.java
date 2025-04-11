package com.acme.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class LoginService {
    public final LoginRepository loginRepository;
    private final RestTemplate loginApi;
    public static final String USERNAME = "assignment-test@ubsend.com";
    public static final String PASSWORD = "p0DrmE)E+BQH$]KasMSb";

    @Autowired
    public LoginService(LoginRepository loginRepository, RestTemplate loginApi) {
        this.loginRepository = loginRepository;
        this.loginApi = loginApi;
    }

    public LoginResponse getLogin(@RequestBody LoginRequest loginRequest) {
        return loginApi.postForObject("/login", loginRequest, LoginResponse.class);
    }

    public String saveLogin() {
        try {
            var response = getLogin(LoginRequest.builder()
                    .username(USERNAME)
                    .password(PASSWORD)
                    .build());
            loginRepository.save(response);
            return response.getAccessToken();
        } catch (Exception e) {
            log.error("Error while saving login response: {}", e.getMessage());
            return "Error";
        }
    }
}
