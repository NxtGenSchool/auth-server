package edu.school.authserver.api;

import edu.school.authserver.domain.exchange.AuthenticateRequest;
import edu.school.authserver.domain.exchange.JwtToken;
import edu.school.authserver.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtTokenService jwtTokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping(path = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public JwtToken authenticate(@RequestBody AuthenticateRequest authenticateRequest) {

        UsernamePasswordAuthenticationToken tokenToAuthenticate = new UsernamePasswordAuthenticationToken(
                authenticateRequest.getUsername(), authenticateRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(tokenToAuthenticate);
        return jwtTokenService.createJwtToken((User)authentication.getPrincipal());
    }
}
