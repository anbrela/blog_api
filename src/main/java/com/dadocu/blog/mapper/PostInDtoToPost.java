package com.dadocu.blog.mapper;

import com.dadocu.blog.persistence.entity.Post;
import com.dadocu.blog.service.dto.PostInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class PostInDtoToPost implements IMapper <PostInDto, Post> {
    
    @Override
    public Post map(PostInDto in) {
        Post post = new Post();
        post.setTitle(in.getTitle());
        post.setContent(in.getContent());
        post.setUserId(in.getUserId());
        post.setCreatedAt(LocalDateTime.now());
        post.setIsPaidContent(in.getIsPaidContent());
        return post;
    }
    
}
