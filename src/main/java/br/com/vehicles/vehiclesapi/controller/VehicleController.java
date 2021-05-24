package br.com.vehicles.vehiclesapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vehicles.vehiclesapi.model.Vehicle;
import br.com.vehicles.vehiclesapi.service.VehicleServiceImpl;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  @Autowired
  private VehicleServiceImpl vehicleServiceImpl;

  @PostMapping("/saveUserVehicle")
  public ResponseEntity<String> saveUserVehicle(@Valid @RequestBody Vehicle vehicle, @RequestParam String email, @RequestParam String cpf){
    return vehicleServiceImpl.save(vehicle, email, cpf);
  }
}
