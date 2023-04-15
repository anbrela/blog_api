package com.dadocu.blog.service.hint;

import com.dadocu.blog.mapper.HintInDtoToHint;
import com.dadocu.blog.persistence.entity.Hint;
import com.dadocu.blog.persistence.entity.Post;
import com.dadocu.blog.persistence.repository.PostRepository;
import com.dadocu.blog.persistence.repository.hint.HintRepository;
import com.dadocu.blog.service.dto.HintInDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HintServiceImpl implements HintService {


    private final HintRepository hintRepository;
    private final PostRepository postRepository;
private final HintInDtoToHint mapper;

    public HintServiceImpl(HintRepository hintRepository, PostRepository postRepository, HintInDtoToHint mapper) {
        this.hintRepository = hintRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }
    
    
    @Override
    public Hint createHint(HintInDto hintInDto) {
        
        Post post = postRepository.findById((long) hintInDto.getPostId()).orElse(null);
        
        if(post == null) {
            return null;
        }
        
        Hint hint = mapper.map(hintInDto);
        return this.hintRepository.save(hint);
    }
    
    @Override
    public List<Hint> findHintsByPostId(Long postId) {
        return hintRepository.findHintsByPostId(postId);
    }
    
}
