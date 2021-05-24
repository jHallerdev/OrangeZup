package br.com.vehicles.vehiclesapi.service;

import org.springframework.http.ResponseEntity;

import br.com.vehicles.vehiclesapi.model.Vehicle;

public interface VehicleService {

    public ResponseEntity<String> save(Vehicle vehicle, String email, String cpf);
    public void setVehiclePrice(Vehicle vehicle);
    public void setVehicleCasterDay(Vehicle vehicle);
    public void setVehicleActiveCarCaster(Vehicle vehicle);
    
}
