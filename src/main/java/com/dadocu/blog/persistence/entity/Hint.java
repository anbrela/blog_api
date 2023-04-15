package com.dadocu.blog.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "post_hint")
public class Hint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    private String question;
    private String answer;
    
    private int postId;
    
    @Column(name = "hint_order")
    private int hintOrder;

    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
}
