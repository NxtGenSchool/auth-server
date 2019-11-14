package edu.school.authserver.service;

import edu.school.authserver.domain.entity.UserCredentials;
import edu.school.authserver.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public JpaUserDetailsService(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsRepository.findByUsername(username);
        return User.builder()
                .username(userCredentials.getUsername())
                .password(userCredentials.getPassword())
                .authorities(new ArrayList<>())
                .build();
    }
}
