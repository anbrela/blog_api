package com.dadocu.blog.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegularException {
    
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();
    private int statusCode;
    
}
