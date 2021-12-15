package com.example.spring_crud.service;

import com.example.spring_crud.dto.UsersDto;
import com.example.spring_crud.entity.Users;
import org.springframework.stereotype.Component;

@Component //Для того, чтобы спринг создал бин моего класса UsersConverter я навешу на него аннотацию @Component. Это позволит мне использовать внедрение зависимостей
// (dependency injection) и подлючить этот класс в мой класс DefaultUsersService используя Spring Dependency Injection.
public class UsersConverter {

    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        return users;
    }
    public UsersDto fromUserToUserDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
}
