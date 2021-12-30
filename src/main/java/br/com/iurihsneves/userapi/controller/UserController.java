package br.com.iurihsneves.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.iurihsneves.userapi.dto.UserDto;

@RestController
public class UserController {
 
    @GetMapping
    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<UserDto>();

        return users;
    }

    @PostMapping
    public UserDto insertUser(@RequestBody UserDto userDto) {
        userDto.setDataCadastro(new Date());
        
        return userDto;
    }

    @DeleteMapping
    public boolean removeUser(@PathVariable String cpf) {

        if(!cpf.equals(null)) {
            return true;
        } else {
            return false;
        }

    }
    
}