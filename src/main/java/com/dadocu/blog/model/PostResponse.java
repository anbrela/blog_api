package com.dadocu.blog.model;

import com.dadocu.blog.persistence.entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse extends PaginatedResponse{
    private List<Post> content;
}
