package com.spring_full_stack.spring.controller;

import com.spring_full_stack.spring.dto.LoginRequestDto;
import com.spring_full_stack.spring.dto.LoginResponseDto;
import com.spring_full_stack.spring.dto.RegisterRequestDto;
import com.spring_full_stack.spring.dto.UserDto;
import com.spring_full_stack.spring.entity.Customer;
import com.spring_full_stack.spring.repository.CustomerRepository;
import com.spring_full_stack.spring.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> apiLogin(@RequestBody LoginRequestDto loginRequestDto) {
        try{
            Authentication authentication = authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(loginRequestDto.username(),
                    loginRequestDto.password()));
            String jwtToken = jwtUtil.generateJwtToken(authentication);
            var userDto = new UserDto();
            var logginUser = (User) authentication.getPrincipal();
            userDto.setFullName(logginUser.getUsername());
            return ResponseEntity.ok(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), userDto, jwtToken));

        }catch(BadCredentialsException e){
            return buildErrorResponse(HttpStatus.UNAUTHORIZED,
                    "Invalid username or password");
        }catch (AuthenticationException ex) {
            return buildErrorResponse(HttpStatus.UNAUTHORIZED,
                    "Authentication failed");
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    "An unexpected error occurred");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> apiRegister(@Valid @RequestBody RegisterRequestDto registerRequestDto) {

        Optional<Customer> existCustomer = customerRepository.findByEmailOrMobileNumber(registerRequestDto.getEmail(), registerRequestDto.getMobileNumber());
        if(existCustomer.isPresent()){
            Map<String, String> errors = new HashMap<>();
            Customer customer = existCustomer.get();
            if(customer.getEmail().equalsIgnoreCase(registerRequestDto.getEmail())){
                errors.put("email", "Email already exists");
            }
            if(customer.getMobileNumber().equalsIgnoreCase(registerRequestDto.getMobileNumber())){
                errors.put("mobileNumber", "Mobile number already exists");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(registerRequestDto, customer);
        customer.setPasswordHash( passwordEncoder.encode(registerRequestDto.getPassword()));
        customerRepository.save(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Registration successful");
    }

    private ResponseEntity<LoginResponseDto> buildErrorResponse(HttpStatus status,
                                                                String message) {
        return ResponseEntity
                .status(status)
                .body(new LoginResponseDto(message, null, null));
    }

}
