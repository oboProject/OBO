package com.example.passion.Mapper;

import com.example.passion.dto.UserDTO;
import com.example.passion.model.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity userResponseDtoToUserEntity(UserDTO.ResponseUserDto responseUserDto);
    UserEntity userRequestDtoToUserEntity(UserDTO.RequestUserDto requestUserDto);
    UserDTO.ResponseUserDto userEntityToResponseUserDto(UserEntity userEntity);
    UserDTO.RequestUserDto userResponseDtoToUserRequestDto(UserDTO.ResponseUserDto responseUserDto);
    UserDTO.ResponseUserDto userRequestDtoToUserResponseDto(UserDTO.RequestUserDto requestUserDto);

}
