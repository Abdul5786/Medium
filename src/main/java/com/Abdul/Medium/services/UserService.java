package com.Abdul.Medium.services;

import com.Abdul.Medium.entities.User;
import com.Abdul.Medium.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
       UserDto createUser(UserDto userDto);
       UserDto updateUser(UserDto userDto,Integer userId);
       UserDto getUserById(Integer UserId);
       Void DeleteUser(Integer userId);
       List<UserDto> getAllUser();
       User dtoToUser(UserDto userDto);
       UserDto userToDto(User user);
}
