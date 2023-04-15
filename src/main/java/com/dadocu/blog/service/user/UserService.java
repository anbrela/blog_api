package com.dadocu.blog.service.user;

import com.dadocu.blog.persistence.entity.User;
import com.dadocu.blog.service.dto.UserInDto;


public interface UserService {
    
    
    User createUser(UserInDto userInDto); 
    
}
