package br.com.vehicles.vehiclesapi.service;


import org.springframework.http.ResponseEntity;

import br.com.vehicles.vehiclesapi.model.User;


public interface UserService {
    
    public ResponseEntity<String> save(User user);

    public ResponseEntity<?> getUserByEmailAndCpf(String email, String cpf);
}
