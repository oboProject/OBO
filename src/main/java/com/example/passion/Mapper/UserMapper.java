package com.example.passion.mapper;

import com.example.passion.dto.UserDTO;
import com.example.passion.domain.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity userResponseDtoToUserEntity(UserDTO.ResponseUserDto responseUserDto);
    UserEntity userRequestDtoToUserEntity(UserDTO.RequestUserDto requestUserDto);
    UserDTO.ResponseUserDto userEntityToResponseUserDto(UserEntity userEntity);
    UserDTO.RequestUserDto userResponseDtoToUserRequestDto(UserDTO.ResponseUserDto responseUserDto);
    UserDTO.ResponseUserDto userRequestDtoToUserResponseDto(UserDTO.RequestUserDto requestUserDto);

}
