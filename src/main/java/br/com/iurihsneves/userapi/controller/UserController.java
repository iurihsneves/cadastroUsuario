package br.com.iurihsneves.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.iurihsneves.userapi.dto.UserDto;
import br.com.iurihsneves.userapi.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
 
    @GetMapping("/user/get-all")
    public List<UserDto> getUsers() {

        List<UserDto> users = new ArrayList<UserDto>();

        users = userService.getAll();

        return users;
    }

    @PostMapping("/user/insert")
    public UserDto insertUser(@RequestBody UserDto userDto) {
        userDto.setDataCadastro(new Date());                
        return userService.save(userDto);
    }

    @GetMapping("/user/find-by-id/{id}")
    public UserDto findById(@PathVariable Long id) {

        return userService.findById(id);

    }

    @DeleteMapping("/user/delete/{id}")
    public UserDto removeUser(@PathVariable Long id) {

        return userService.delete(id);

    }

    @GetMapping("/user/cpf/{cpf}")
    public UserDto findByCpf(@PathVariable String cpf) {

        return userService.findByCpf(cpf);

    }

    @GetMapping("/user/find-by-name")
    public List<UserDto> queryByName(@RequestParam(name="name", required=true) String name) {

        return userService.queryByName(name);

    }
    
}