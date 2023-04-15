package com.dadocu.blog.persistence.repository;

import com.dadocu.blog.model.PostFilter;
import com.dadocu.blog.model.PostResponse;
import com.dadocu.blog.persistence.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    PostResponse findAllByCriteria(PostFilter criteria);
    

}
