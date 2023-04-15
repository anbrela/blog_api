package com.dadocu.blog.service.user;

import com.dadocu.blog.mapper.user.UserInDtoToUser;
import com.dadocu.blog.persistence.entity.User;
import com.dadocu.blog.persistence.repository.user.UserRepository;
import com.dadocu.blog.service.dto.UserInDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    private final UserInDtoToUser mapper;
    
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository, UserInDtoToUser mapper) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }
    
    
    @Override
    public User createUser(UserInDto userInDto) {
        User user = mapper.map(userInDto);
        return userRepository.save(user);
    }
}
