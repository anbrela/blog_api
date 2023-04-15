package com.dadocu.blog.model;


import lombok.Data;

@Data
public class PageFilter {
    
    private int offset;
    private int limit;
    
    private int sort;
    
}
