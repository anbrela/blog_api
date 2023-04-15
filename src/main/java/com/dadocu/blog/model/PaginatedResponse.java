package com.dadocu.blog.model;

import lombok.Data;

@Data
public class PaginatedResponse {
    
    private int offset;
    private int limit;
    private Long totalElements;
}
