package com.dadocu.blog.service.answer;

import com.dadocu.blog.service.dto.AnswerInDto;
import com.dadocu.blog.persistence.entity.Answer;
import com.dadocu.blog.persistence.repository.answer.AnswerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    
    private final AnswerRepository answerRepository;
    
    
    public AnswerServiceImpl( AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;

    }


    
    @Override
    public ResponseEntity<?> submitAnswer(AnswerInDto answerInDto) {
        Long postId = answerInDto.getPostId();
        Optional<Answer> answer = answerRepository.findByPostId(postId);
        if (answer.isPresent()) {
            if (answer.get().getAnswer().equals(answerInDto.getAnswer())
            ) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Respuesta correcta");
            } else {
                return ResponseEntity.badRequest().body("La respuesta no es correcta");
            }
        } else {
            return ResponseEntity.badRequest().body("No se encontro el post");
        }
    }


        @Override
    public Answer createAnswer(AnswerInDto answerInDto) {
        return answerRepository.createAnswer(answerInDto);
    }
}
