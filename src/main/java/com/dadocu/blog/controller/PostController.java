package com.dadocu.blog.controller;


import com.dadocu.blog.exceptions.RegularException;
import com.dadocu.blog.model.PostFilter;
import com.dadocu.blog.model.PostResponse;
import com.dadocu.blog.persistence.entity.Post;

import com.dadocu.blog.service.PostService;
import com.dadocu.blog.service.dto.PostInDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name="PostController")
@RequestMapping("/api/posts")
public class PostController {
    
    
    private final PostService service;

    
    
    public PostController(PostService service) {
        
        this.service = service;
    }
    
    @PostMapping
    public Post createPost (@RequestBody PostInDto postInDto) {
    return this.service.createPost(postInDto);
    }

    
    @GetMapping
    public PostResponse getAllPosts(
           @RequestParam(name = "offset", required = false, defaultValue = "0") int offset,
           @RequestParam(name = "limit", required = false, defaultValue = "3") int limit,
           @RequestParam(name = "userId", required = false) Long userId,
           @RequestParam(name = "title", required = false) String title,
           @RequestParam(name = "isPaidContent", required = false) Boolean isPaidContent
            
    ) {
        
        PostFilter postFilter = new PostFilter();
        postFilter.setOffset(offset);
        postFilter.setLimit(limit);
        postFilter.setUserId(userId);
        postFilter.setTitle(title);
        postFilter.setIsPaidContent(isPaidContent);
        
        return this.service.getAllPosts(postFilter);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable long id) {
        
        Post post = this.service.getPostById(id);
        
        if(post == null) {
            RegularException exception = new RegularException();
            exception.setMessage("Post not found");
            exception.setStatusCode(HttpStatus.NOT_FOUND.value());
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
        }
        
        return ResponseEntity.ok(post);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable long id) {
        
            int deleted = this.service.deletePostById(id);
            if(deleted == 0) {
                RegularException exception = new RegularException();
                exception.setMessage("Post not found");
                exception.setStatusCode(HttpStatus.NOT_FOUND.value());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
            } else {
                return ResponseEntity.noContent().build();
            }
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePostById(@PathVariable long id, @RequestBody PostInDto postInDto) {

        Post updated = this.service.updatePostById(id, postInDto);

        if (updated == null) {
            RegularException exception = new RegularException();
            exception.setMessage("Post not found");
            exception.setStatusCode(HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
        } else {
            return ResponseEntity.ok(updated);
        }

    }
    
}
