package com.dadocu.blog.service.dto;
import lombok.Data;


@Data
public class PostInDto {

    private String title;
    private String content;
    private Boolean isPaidContent = false;
    private long userId;
    
}
