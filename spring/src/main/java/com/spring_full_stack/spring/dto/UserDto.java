package com.spring_full_stack.spring.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

    private int userId;
    private String fullName;
    private String email;

}
