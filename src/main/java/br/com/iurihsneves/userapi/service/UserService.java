package br.com.iurihsneves.userapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.iurihsneves.userapi.dto.UserDto;
import br.com.iurihsneves.userapi.model.User;
import br.com.iurihsneves.userapi.repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users
            .stream()
            .map(UserDto::convert)
            .collect(Collectors.toList());
    }

    public UserDto findById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return UserDto.convert(user.get());
        }

        return null;
    }

    public UserDto save(UserDto userDto) {
        User user = userRepository.save(User.convert(userDto));
        return UserDto.convert(user);
    }

    public UserDto delete(Long id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            userRepository.deleteById(id);
        }

        return null;

    }

    public UserDto findByCpf(String cpf) {
        
        User user = userRepository.findByCpf(cpf);

        if(user != null) {
            return UserDto.convert(user);
        }

        return null;

    }

    public List<UserDto> queryByName(String name) {

        List<User> users = userRepository.queryByNomeLike(name);
        return users
                .stream()
                .map(UserDto::convert)
                .collect(Collectors.toList());
    }
    
}
