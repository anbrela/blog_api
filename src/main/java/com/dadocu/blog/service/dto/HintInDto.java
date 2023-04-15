package com.dadocu.blog.service.dto;

import lombok.Data;

@Data
public class HintInDto {
    
    private String question;
    
    private int hintOrder;
    
    private int postId;
    private String answer;
}
