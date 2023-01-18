package com.spring.socialmediarestapp.service.impls;

import com.spring.socialmediarestapp.entity.User;
import com.spring.socialmediarestapp.repo.UserRepo;
import com.spring.socialmediarestapp.service.UserService;
import com.spring.socialmediarestapp.utils.request.UserDTO;
import com.spring.socialmediarestapp.utils.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public BaseResponse saveUser(UserDTO userDTO) {
        BaseResponse baseResponse = new BaseResponse();

        User user = toEntity(userDTO);
        User savedUser = userRepo.save(user);

        baseResponse.setData(savedUser);
        baseResponse.setCode(HttpStatus.OK.toString());
        baseResponse.setSuccess(true);
        return baseResponse;
    }

    public User toEntity(UserDTO userDTO){
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setStartTime(userDTO.getStartTime());
        user.setEndTime(userDTO.getEndTime());
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());

        return user;
    }
}
