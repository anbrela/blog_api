package com.dadocu.blog.service.answer;

import com.dadocu.blog.service.dto.AnswerInDto;
import com.dadocu.blog.persistence.entity.Answer;
import org.springframework.http.ResponseEntity;

public interface AnswerService {
    
ResponseEntity<?> submitAnswer(AnswerInDto answerInDto);

Answer createAnswer(AnswerInDto answerInDto);
    
}
