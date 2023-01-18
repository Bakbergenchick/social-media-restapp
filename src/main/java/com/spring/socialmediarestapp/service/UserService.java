package com.spring.socialmediarestapp.service;

import com.spring.socialmediarestapp.utils.request.UserDTO;
import com.spring.socialmediarestapp.utils.response.BaseResponse;

public interface UserService {
    BaseResponse saveUser(UserDTO userDTO);
}
