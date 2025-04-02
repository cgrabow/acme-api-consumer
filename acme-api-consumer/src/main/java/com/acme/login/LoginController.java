package com.acme.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping("/logins")
    public LoginResponse saveLoginResponse(@RequestBody LoginResponse loginResponse) {

        return loginRepository.save(loginResponse);
    }
}
