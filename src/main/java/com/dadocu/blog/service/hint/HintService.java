package com.dadocu.blog.service.hint;

import com.dadocu.blog.persistence.entity.Hint;
import com.dadocu.blog.service.dto.HintInDto;

import java.util.List;

public interface HintService {


    List<Hint> findHintsByPostId(Long postId);
    Hint createHint(HintInDto hintInDto);

}
