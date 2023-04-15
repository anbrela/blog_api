package com.dadocu.blog.persistence.repository;

import com.dadocu.blog.model.PostFilter;
import com.dadocu.blog.model.PostResponse;
import com.dadocu.blog.persistence.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PostRepositoryImpl extends SimpleJpaRepository<Post, Long> implements PostRepository {

    private final EntityManager entityManager;

    public PostRepositoryImpl(EntityManager entityManager) {
        super(Post.class, entityManager);
        this.entityManager = entityManager;
    }

    
    //todo: Refactor this method
    @Override
    public PostResponse findAllByCriteria(PostFilter postFilter) {
        Pageable pageable = PageRequest.of(postFilter.getOffset() / postFilter.getLimit(), postFilter.getLimit());


        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);

        List<Predicate> predicates = new ArrayList<>();

        if (postFilter.getUserId() != null) {
            predicates.add(criteriaBuilder.equal(postRoot.get("userId"), postFilter.getUserId()));
        }

        if (postFilter.getTitle() != null) {
            predicates.add(criteriaBuilder.equal(postRoot.get("title"), postFilter.getTitle()));
        }

        if (postFilter.getIsPaidContent() != null) {
            predicates.add(criteriaBuilder.equal(postRoot.get("isPaidContent"), postFilter.getIsPaidContent()));
        }

        if (!predicates.isEmpty()) {
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
        }

        TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        
        
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(query.getResultList());
        postResponse.setOffset(query.getFirstResult());
        postResponse.setLimit(query.getMaxResults());
        postResponse.setTotalElements((long) query.getResultList().size());

        return postResponse;
    }
    
}