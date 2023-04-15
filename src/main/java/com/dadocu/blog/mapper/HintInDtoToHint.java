package com.dadocu.blog.mapper;

import com.dadocu.blog.persistence.entity.Hint;
import com.dadocu.blog.service.dto.HintInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class HintInDtoToHint implements IMapper <HintInDto, Hint> {
    
    @Override
    public Hint map(HintInDto in) {
        Hint hint = new Hint();
        hint.setQuestion(in.getQuestion());
        hint.setHintOrder(in.getHintOrder());
        hint.setPostId(in.getPostId());
        hint.setAnswer(in.getAnswer());
        hint.setCreatedAt(LocalDateTime.now());
        return hint;
    }
}
