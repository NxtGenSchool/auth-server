package edu.school.authserver.service;

import edu.school.authserver.domain.exchange.JwtToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenService {

    public JwtToken createJwtToken(User user) {
        String token = Jwts.builder().setSubject(user.getUsername()).signWith(
                SignatureAlgorithm.HS512, "chachacha").compact();
        JwtToken jwtToken = new JwtToken();
        jwtToken.setToken(token);
        return jwtToken;
    }
}
