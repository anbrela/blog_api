package com.dadocu.blog.persistence.repository.answer;

import com.dadocu.blog.service.dto.AnswerInDto;
import com.dadocu.blog.persistence.entity.Answer;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public class AnswerRepositoryImpl extends SimpleJpaRepository<Answer, Long> implements AnswerRepository {

    
    public AnswerRepositoryImpl(EntityManager entityManager) {
        super(Answer.class, entityManager);
    }

    @Override
    public Optional<Answer> findByPostId(Long postId) {
        return findOne((root, query, cb) -> cb.equal(root.get("postId"), postId));
    }
    
    
    
    @Override
    public Answer createAnswer(AnswerInDto answerInDto) {
        Answer answer = new Answer();
        answer.setAnswer(answerInDto.getAnswer());
        answer.setPostId(answerInDto.getPostId());
        return save(answer);
    }

}
