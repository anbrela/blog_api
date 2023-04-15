package com.dadocu.blog.service;

import com.dadocu.blog.model.PostFilter;
import com.dadocu.blog.model.PostResponse;
import com.dadocu.blog.persistence.entity.Post;
import com.dadocu.blog.service.dto.PostInDto;



public interface PostService {
    
    PostResponse getAllPosts(PostFilter postFilter);
    Post createPost (PostInDto postInDto);
    
    Post getPostById(long id);
    
    int deletePostById(long id);

    Post updatePostById(long id, PostInDto postInDto);
    
}
