package com.dadocu.blog.service;

import com.dadocu.blog.mapper.PostInDtoToPost;
import com.dadocu.blog.model.PostFilter;
import com.dadocu.blog.model.PostResponse;

import com.dadocu.blog.persistence.entity.Post;
import com.dadocu.blog.persistence.repository.PostRepository;
import com.dadocu.blog.persistence.repository.hint.HintRepository;
import com.dadocu.blog.service.dto.PostInDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostInDtoToPost mapper;

    public PostServiceImpl(PostRepository postRepository, PostInDtoToPost mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public PostResponse getAllPosts(PostFilter filter) {
        return postRepository.findAllByCriteria(filter);
    }
    
    
    @Override
    public Post createPost(PostInDto postInDto) {
        Post post = mapper.map(postInDto);
        return postRepository.save(post);
    }
    
    
    @Override
    public Post getPostById(long id) {
        Post post = postRepository.findById(id).orElse(null);
        
        if(post == null) {
            return null;
        }
        
        return postRepository.findById(id).orElse(null);
    }
    
    
    @Override
    public int deletePostById(long id) {
        
        if(existsById(id)) {
            postRepository.deleteById(id);
            return 1;
        }
        
        return 0;
    }
    
    @Override
    public Post updatePostById(long id, PostInDto postInDto) {
        
            Post oldPost = postRepository.findById(id).orElse(null);
            if(oldPost != null) {
                Post post = new Post();
                BeanUtils.copyProperties(oldPost, post);
                post = mapper.map(postInDto);
                return postRepository.save(post);
            }
           
        
        return null;
    }
    
    
    private Boolean existsById(long id) {
        Optional<Post> byId = postRepository.findById(id);
        return byId.isPresent();
    }
    
    
}
