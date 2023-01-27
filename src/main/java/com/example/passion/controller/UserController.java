package com.example.passion.controller;

import com.example.passion.dto.UserDTO;
import com.example.passion.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUserEntity(@RequestParam String email){
        UserDTO.RequestUserDto requestUserDto =
                UserDTO.RequestUserDto.builder().email(email).build();

        return new ResponseEntity(userService.getUser(requestUserDto), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity postUser(@RequestBody UserDTO.RequestUserDto requestUserDto){
        return new ResponseEntity(userService.createUser(requestUserDto), HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity patchUser(@RequestBody UserDTO.RequestUserDto requestUserDto){
        return new ResponseEntity(userService.modifyUser(requestUserDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody UserDTO.RequestUserDto requestUserDto){
        return new ResponseEntity(userService.deleteUser(requestUserDto),HttpStatus.OK);
    }

}
