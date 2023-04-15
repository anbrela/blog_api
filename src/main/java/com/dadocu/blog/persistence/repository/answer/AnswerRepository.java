package com.dadocu.blog.persistence.repository.answer;


import com.dadocu.blog.service.dto.AnswerInDto;
import com.dadocu.blog.persistence.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {


    @Query("SELECT a FROM Answer a WHERE a.postId = :postId")
    Optional<Answer> findByPostId(Long postId);
    Answer createAnswer(AnswerInDto answerInDto);
    
    
}
