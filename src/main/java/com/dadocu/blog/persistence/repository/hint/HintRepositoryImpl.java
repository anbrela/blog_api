package com.dadocu.blog.persistence.repository.hint;


import com.dadocu.blog.persistence.entity.Hint;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HintRepositoryImpl extends SimpleJpaRepository<Hint, Long> implements HintRepository {

    

    public HintRepositoryImpl(EntityManager entityManager) {
        super(Hint.class, entityManager);

    }


    @Override
    public List<Hint> findHintsByPostId(Long postId) {
        return this.findAll();
    }
    
    
}
