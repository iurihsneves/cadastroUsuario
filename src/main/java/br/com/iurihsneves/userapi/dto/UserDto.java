package br.com.iurihsneves.userapi.dto;

import java.util.Date;

import br.com.iurihsneves.userapi.model.User;
import lombok.Data;

@Data
public class UserDto {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

    public static UserDto convert(User user) {

        UserDto userDto = new UserDto();

        userDto.setNome(user.getNome());
        userDto.setEndereco(user.getEndereco());
        userDto.setCpf(user.getCpf());
        userDto.setEmail(user.getEmail());
        userDto.setTelefone(user.getTelefone());
        userDto.setDataCadastro(user.getDataCadastro());
        
        return userDto;

    }

}
