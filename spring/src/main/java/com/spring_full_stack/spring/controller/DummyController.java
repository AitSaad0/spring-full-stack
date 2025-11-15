package com.spring_full_stack.spring.controller;


import com.spring_full_stack.spring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/dummy")
public class DummyController {

    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return "user created";
    }


    @GetMapping("/get-user")
    public String getUser(@RequestParam Map<String, String> params){

        return "user is " + params.get("firstName") +  " " + params.get("email") ;
    }

    @GetMapping({"/user/{userId}", "/user/{userId}/num/{num}"})
    public String pathTest(@PathVariable Map<String, String> params){
        return  "user is " +  params.get("userId") +  " " + params.get("num") ;
    }
}
