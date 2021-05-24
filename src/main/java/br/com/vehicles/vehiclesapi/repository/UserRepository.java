package br.com.vehicles.vehiclesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vehicles.vehiclesapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(value = "select * from user where email = ?1 and cpf = ?2", nativeQuery = true)
    public User getUserByEmailAndCpf(String email, String cpf);
}