package com.Abdul.Medium.services.serviceimpl;

import com.Abdul.Medium.config.ModelMapperConfig;
import com.Abdul.Medium.entities.User;
import com.Abdul.Medium.exceptions.ResourceNoutFoundException;
import com.Abdul.Medium.payloads.UserDto;
import com.Abdul.Medium.repositories.UserRepo;
import com.Abdul.Medium.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapperConfig modelMapper;
    @Override
    public UserDto createUser(UserDto userDto)
    {
        User user = this.dtoToUser(userDto);
        User save = userRepo.save(user);
        return   this.userToDto(save);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId)
    {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNoutFoundException("nhii milega ", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        User save = userRepo.save(user);
        return this.userToDto(save);

    }

    @Override
    public UserDto getUserById(Integer userId)
    {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNoutFoundException("bhaiya m toh tut gya", "id", userId));
        return  this.userToDto(user);
    }

    @Override
    public Void DeleteUser(Integer userId)
    {
        User deleteUser = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNoutFoundException("Bhai", "id", userId));
        this.userRepo.delete(deleteUser);
        return null;
    }

    @Override
    public List<UserDto> getAllUser()
    {
        List<User> allUser = this.userRepo.findAll();
        List<UserDto> userDtos = allUser.stream().map(a -> this.userToDto(a)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public User dtoToUser(UserDto userDto)
    {
        User user = this.modelMapper.modelMapper().map(userDto, User.class);
        return user;
    }

    @Override
    public UserDto userToDto(User user)
    {
        UserDto userDto = this.modelMapper.modelMapper().map(user, UserDto.class);
        return userDto;
    }



}
