package com.dadocu.blog.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "answer")
@Data
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    
    @Column(name = "post_id", unique = true)
    private Long postId;
    
}
