package com.spring_full_stack.spring.security;

import com.spring_full_stack.spring.entity.Customer;
import com.spring_full_stack.spring.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FullStackUsernamePwdAuthenticationProvider implements AuthenticationProvider {


    private final CustomerRepository customerRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Customer customer = customerRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User details not found")
        );
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
