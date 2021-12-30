package br.com.iurihsneves.userapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iurihsneves.userapi.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
 
    User findByCpf(String cpf);

    User deleteByCpf(String cpf);

    List<User> queryByNomeLike(String name);

}
