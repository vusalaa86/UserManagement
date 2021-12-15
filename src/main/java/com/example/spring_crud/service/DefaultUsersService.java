package com.example.spring_crud.service;

import com.example.spring_crud.dto.UsersDto;
import com.example.spring_crud.entity.Users;
import com.example.spring_crud.exeption.ValidationException;
import com.example.spring_crud.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import com.example.spring_crud.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
@Data
@AllArgsConstructor
@Service
public class DefaultUsersService implements UsersService{
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    @Override
    public UsersDto saveUser(UsersDto usersDto) {
//        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
       usersRepository.deleteById(userId);

    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll().stream().map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

    
    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if(isNull(usersDto)) {
            throw new ValidationException("object user is Null");
        }
                    if(isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty());{
                        throw new ValidationException("login is empty");
        }
    }

}
