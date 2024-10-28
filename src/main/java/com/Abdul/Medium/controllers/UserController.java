package com.Abdul.Medium.controllers;

import com.Abdul.Medium.payloads.ApiResponse;
import com.Abdul.Medium.payloads.UserDto;
import com.Abdul.Medium.services.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto userdto = userService.createUser(userDto);
        return new ResponseEntity<>(userdto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
    {
        UserDto updateUser = userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }

    @GetMapping( value = "/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId)
    {
        UserDto userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        List<UserDto> allUser = userService.getAllUser();
        return   ResponseEntity.ok(allUser);
    }


//    delete controller

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer UserId)
    {
                 userService.DeleteUser(UserId);
                 return new ResponseEntity<ApiResponse>(new ApiResponse("khatam tata bye bye",true),HttpStatus.OK);
    }


}
