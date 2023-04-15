package com.dadocu.blog.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hint> hints = new ArrayList<>();
    
    private String title;
    private String content;
    
    @Column(name = "user_id")
    private long userId;

    @Column(name = "created_at")
    private LocalDateTime createdAt; 
    
    @Column(name = "is_paid_content")
    private Boolean isPaidContent;
    
}
