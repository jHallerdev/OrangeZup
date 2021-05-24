package br.com.vehicles.vehiclesapi.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import br.com.vehicles.vehiclesapi.model.User;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class UserDto{

    private String name;

    private String email;

    private String cpf;

    private Date birthDate;

    private List<VehicleDto> vehicles = new ArrayList<VehicleDto>();

    public UserDto(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.birthDate = user.getBirthDate();
        this.vehicles = VehicleDto.convertToList(user.getVehicles());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString(){
        return this.name + this.email + this.cpf + this.birthDate + this.vehicles.toString();
    }
}