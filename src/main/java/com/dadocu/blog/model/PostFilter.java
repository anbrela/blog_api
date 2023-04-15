package com.dadocu.blog.model;

import lombok.Data;

@Data
public class PostFilter extends PageFilter {
    
    private Long userId;
    private Boolean isPaidContent;
    private String title;
    
}


