package com.dadocu.blog.controller;

import com.dadocu.blog.service.dto.UserInDto;
import com.dadocu.blog.service.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="User") 
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService service;
    
    public UserController(UserService service) {
        this.service = service;
    }
    



    @PostMapping("/")
    public ResponseEntity<Object> createUser(@RequestBody UserInDto userInDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createUser(userInDto));
    }
    
    
    
}
