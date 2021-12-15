package com.example.spring_crud.controller;
import com.example.spring_crud.dto.UsersDto;
import com.example.spring_crud.exeption.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.spring_crud.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Data
public class UserController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUser(@RequestBody UsersDto usersDto) {
        return usersService.saveUser(usersDto);
    }
    @GetMapping("/findAll")
    public List<UsersDto>findAllUsers(){

        return usersService.findAll();
    }
    @GetMapping("findByLogin")
    public UsersDto findByLogin(@RequestParam String login){

        return usersService.findByLogin(login);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteUsers(@PathVariable Integer id){
         usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
