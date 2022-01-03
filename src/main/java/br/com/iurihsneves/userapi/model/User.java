package br.com.iurihsneves.userapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.iurihsneves.userapi.dto.UserDto;
import lombok.Data;

@Data
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

    public static User convert(UserDto userDto) {

        User user = new User();
        user.setNome(userDto.getNome());
        user.setEndereco(userDto.getEndereco());
        user.setCpf(userDto.getCpf());
        user.setEmail(userDto.getEmail());
        user.setTelefone(userDto.getTelefone());
        user.setDataCadastro(userDto.getDataCadastro());
        return user;

    }
}
