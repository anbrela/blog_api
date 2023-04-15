package com.dadocu.blog.service.dto;


import lombok.Data;

@Data
public class UserInDto {
    
    private String username;
    private String password;
    
    private String email;
    
    private String avatar = null;
    
}
