package com.example.spring_crud.service;

import com.example.spring_crud.dto.UsersDto;
import com.example.spring_crud.exeption.ValidationException;

import java.util.List;

public interface UsersService {

    UsersDto saveUser(UsersDto usersDto);
    void deleteUser (Integer userId);
    UsersDto findByLogin(String login);
    List<UsersDto>findAll();


}
