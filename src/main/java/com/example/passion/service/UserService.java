package com.example.passion.service;

import com.example.passion.Mapper.UserMapper;
import com.example.passion.dto.UserDTO;
import com.example.passion.model.user.UserEntity;
import com.example.passion.repository.UserRepository;

import java.util.List;

public class UserService implements UserCRUD<UserDTO.ResponseUserDto,UserDTO.RequestUserDto>{

    UserRepository userRepository;
    UserMapper mapper;

    @Override
    public UserDTO.ResponseUserDto createUser(UserDTO.RequestUserDto requestUserDto) {

        UserEntity savedUserEntity = mapper.userRequestDtoToUserEntity(requestUserDto);
        return mapper.userEntityToResponseUserDto(userRepository.save(savedUserEntity));

    }

    @Override
    public UserDTO.ResponseUserDto deleteUser(UserDTO.RequestUserDto requestUserDto) {

        return null;
    }

    @Override
    public UserDTO.ResponseUserDto modifyUser(UserDTO.RequestUserDto requestUserDto) {
        return null;
    }

    @Override
    public List<UserDTO.ResponseUserDto> getUser(UserDTO.RequestUserDto requestUserDto) {
        return null;
    }
}
