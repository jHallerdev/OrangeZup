package br.com.vehicles.vehiclesapi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@JsonIgnoreProperties(value = {"vehicles"})

public class User {

    @Id
    private long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    @javax.validation.constraints.Email
    private String email;

    @Column(nullable = false)
    @CPF
    private String cpf;

    @Column(name = "birth_date")
    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate = new Date();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public User(long id, String name, String email, String cpf, Date birthDate, List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.vehicles = vehicles;
    }

    public User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addOneDayToBirthDate(){
        Calendar c = Calendar.getInstance();

        c.setTime(this.birthDate);
        c.add(Calendar.DAY_OF_MONTH, 1);

        this.birthDate = c.getTime();
    }

    @Override
    public String toString(){
        return this.name + this.email + this.cpf + this.birthDate + this.vehicles.toString();
    }
}