package com.spring_full_stack.spring.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

    private int userId;

    @NotBlank(message = "Name must not be blank")
    @Size(max = 30, message = "Name must not be have more than 30 character")
    private String fullName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "you must enter a valid Email")
    private String email;

}
