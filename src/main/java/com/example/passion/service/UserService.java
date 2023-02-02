package com.example.passion.service;

import com.example.passion.mapper.UserMapper;
import com.example.passion.dto.UserDTO;
import com.example.passion.model.user.UserEntity;
import com.example.passion.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
        userRepository.delete(mapper.userRequestDtoToUserEntity(requestUserDto));
        return new UserDTO.ResponseUserDto();
    }

    @Override
    @Transactional
    public UserDTO.ResponseUserDto modifyUser(UserDTO.RequestUserDto requestUserDto) {

        UserEntity modifiedUserEntity = mapper.userRequestDtoToUserEntity(requestUserDto);
        UserEntity userOriginal  = userRepository.findUserEntityByUserId(requestUserDto.getUserId());

        userOriginal.update(requestUserDto.getUserId(), requestUserDto.getDisplayName(),
                requestUserDto.getEmail(),
                requestUserDto.getPassword(),
                requestUserDto.getState(),
                requestUserDto.getCity(),
                requestUserDto.getUserInfo(),
                requestUserDto.getCareer(),
                requestUserDto.getEducation(),
                requestUserDto.getCompany());
        return mapper.userEntityToResponseUserDto(userOriginal);
    }

    @Override
    public List<UserDTO.ResponseUserDto> getUser(UserDTO.RequestUserDto requestUserDto) {

        List<UserDTO.ResponseUserDto> responseUserDtos = new ArrayList<>();

        responseUserDtos.add(
                mapper.userEntityToResponseUserDto(
                                (userRepository.findUserEntityByEmail(requestUserDto.getEmail()))));
        return responseUserDtos;

    }
}
