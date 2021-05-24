package br.com.vehicles.vehiclesapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vehicles.vehiclesapi.model.User;
import br.com.vehicles.vehiclesapi.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody User user){
        System.out.println(user.getBirthDate());
        return userServiceImpl.save(user);
    }

    @GetMapping("/getUserByEmailAndCpf")
    public ResponseEntity<?> getUserByEmailAndCpf(@RequestParam String email, @RequestParam String cpf){
        return userServiceImpl.getUserByEmailAndCpf(email, cpf);
    }
}
