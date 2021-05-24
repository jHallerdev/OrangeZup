package br.com.vehicles.vehiclesapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import br.com.vehicles.vehiclesapi.model.Vehicle;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class VehicleDto{

    private String type;

    private String brand;

    private String model;

    private String year;
    
    private String price;

    private String casterDay;

    private boolean activeCarCaster;

    public VehicleDto(Vehicle vehicle){
        this.type = vehicle.getType();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.year = vehicle.getYear();
        this.price = vehicle.getPrice();
        this.casterDay = vehicle.getCasterDay();
        this.activeCarCaster = vehicle.isActiveCarCaster();
    }  
    
    public static List<VehicleDto> convertToList(List<Vehicle> vehicles){
        List<VehicleDto> vehiclesDto = new ArrayList<VehicleDto>();
        for(Vehicle vehicle : vehicles){
            vehiclesDto.add(new VehicleDto(vehicle));
        }
        return vehiclesDto;
    }

    @Override
    public String toString(){
        return this.type + this.brand + this.model + this.year + this.price + this.casterDay + this.activeCarCaster;
    }
}
