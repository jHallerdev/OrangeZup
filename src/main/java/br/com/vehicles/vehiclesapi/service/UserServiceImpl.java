package br.com.vehicles.vehiclesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vehicles.vehiclesapi.dto.UserDto;
import br.com.vehicles.vehiclesapi.model.User;
import br.com.vehicles.vehiclesapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> save(User user){
        try{
            user.addOneDayToBirthDate();
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created sucessfully!");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot save user. Revise your data!");
        }
    }
    
    @Override
    public ResponseEntity<?> getUserByEmailAndCpf(String email, String cpf){
        try{

            return ResponseEntity.ok(new UserDto(userRepository.getUserByEmailAndCpf(email, cpf)));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with email: "+email+" cpf: "+cpf);
        }
    }
    
}
