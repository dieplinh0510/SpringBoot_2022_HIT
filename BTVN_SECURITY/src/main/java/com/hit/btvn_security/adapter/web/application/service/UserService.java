package com.hit.btvn_security.adapter.web.application.service;

import com.hit.btvn_security.adapter.web.application.dai.UserRepository;
import com.hit.btvn_security.adapter.web.application.mapper.UserMapper;
import com.hit.btvn_security.adapter.web.v1.transfer.response.TrueFalseResponse;
import com.hit.btvn_security.domain.dto.UserDto;
import com.hit.btvn_security.domain.entity.User;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

//    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User createNewUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
//        return userRepository.save(userMapper.toUser(userDto));
        return userRepository.save(user);
    }


    public TrueFalseResponse deleteUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
//            throw new exception
            return new TrueFalseResponse(false);
        }
        userRepository.deleteById(id);
        return new TrueFalseResponse(true);
    }

}
