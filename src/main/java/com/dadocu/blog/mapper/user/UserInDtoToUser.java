package com.dadocu.blog.mapper.user;

import com.dadocu.blog.mapper.IMapper;
import com.dadocu.blog.persistence.entity.User;
import com.dadocu.blog.service.dto.UserInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserInDtoToUser implements IMapper<UserInDto, User> {
    
    @Override
    public User map(UserInDto in) {
        User user = new User();
        user.setPassword(in.getPassword());
        user.setUsername(in.getUsername());
        user.setEmail(in.getEmail());
        user.setAvatar(in.getAvatar());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }
    
    
}
