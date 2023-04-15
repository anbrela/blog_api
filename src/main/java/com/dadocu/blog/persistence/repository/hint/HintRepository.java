package com.dadocu.blog.persistence.repository.hint;

import com.dadocu.blog.persistence.entity.Hint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HintRepository extends JpaRepository<Hint, Long> {
    
    @Query("SELECT h FROM Hint h WHERE h.postId = :postId")
    List<Hint> findHintsByPostId(Long postId);
    

}
