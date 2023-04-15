package com.dadocu.blog.controller;

import com.dadocu.blog.exceptions.RegularException;
import com.dadocu.blog.persistence.entity.Hint;
import com.dadocu.blog.service.dto.HintInDto;
import com.dadocu.blog.service.hint.HintService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/hints")
public class HintController {
    
    
    
    private final HintService service;
    
    
    public HintController(HintService service) {
        this.service = service;
    }
    
    
    @PostMapping
    public ResponseEntity<?> createHint(@RequestBody HintInDto hintInDto) {
        Hint hint = service.createHint(hintInDto);
        if(hint == null) {
            RegularException Re = new RegularException();
            Re.setMessage("Post not found");
            return ResponseEntity.badRequest().body(Re);
        }
        return ResponseEntity.ok(hint);
    }
    
    
    @GetMapping("/post/{id}")
    public ResponseEntity<List<Hint>> getHintsByPostId(@PathVariable long id) {
        return ResponseEntity.ok(service.findHintsByPostId(id));
    }
    
    
    
}
