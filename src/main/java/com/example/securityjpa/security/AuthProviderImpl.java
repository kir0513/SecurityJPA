package com.example.securityjpa.security;

import com.example.securityjpa.service.PersonDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private final PersonDetailsService personDetailsService;

    public AuthProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails personDetails= personDetailsService.loadUserByUsername(username);
        //получаем введенный сформы пароль
        String password = authentication.getCredentials().toString();
        if(!password.equals(personDetails.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        } else {
            return  new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
