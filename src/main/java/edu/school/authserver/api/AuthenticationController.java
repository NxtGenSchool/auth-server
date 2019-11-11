package edu.school.authserver.api;

import edu.school.authserver.domain.exchange.AuthenticateRequest;
import edu.school.authserver.domain.exchange.JwtToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PostMapping(path = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public JwtToken authenticate(AuthenticateRequest authenticateRequest) {
        return new JwtToken();
    }
}
