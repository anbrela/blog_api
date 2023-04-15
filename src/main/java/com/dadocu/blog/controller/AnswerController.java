package com.dadocu.blog.controller;


import com.dadocu.blog.persistence.entity.Answer;
import com.dadocu.blog.service.answer.AnswerService;
import com.dadocu.blog.service.dto.AnswerInDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Answer", description = "Answer API")
@RequestMapping("/api/answers")
public class AnswerController {
    
    private final AnswerService service;
    
    public AnswerController(AnswerService service) {
        this.service = service;
    }
    
    @PostMapping("/submit")
    public ResponseEntity<?> submitAnswer(@RequestBody AnswerInDto answerInDto) {
        return service.submitAnswer(answerInDto);
    }
    
    @PostMapping
    public ResponseEntity<?> createAnswer(@RequestBody AnswerInDto answerInDto) {
        Answer answer = service.createAnswer(answerInDto);
        
        if(answer == null) {
            return ResponseEntity.badRequest().body("Answer not created");
        }
        
        return ResponseEntity.ok(answer);
    }
    
}
