package com.spring_full_stack.spring.dto;

public record LoginResponseDto(String message, UserDto user, String token) {
}
