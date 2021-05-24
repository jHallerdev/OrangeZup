package br.com.vehicles.vehiclesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"price", "casterDay", "activeCarCaster", "user"})
public class Vehicle {
    
    @Id
    private long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String year;
    
    @Column(nullable = false)
    private String price;

    @Column(name = "caster_day", nullable = false)
    private String casterDay;

    @Column(name = "active_car_caster", nullable = false)
    private boolean activeCarCaster;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user = new User();

    @Transient
    private String brandCode;

    @Transient
    private String modelCode;

    @Transient
    private String yearCode;
    
    public Vehicle(User user, long id, String brand, String model, String year, String price, String casterDay,
            boolean activeCarCaster, String brandCode, String modelCode, String yearCode) {
        this.user = user;
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.casterDay = casterDay;
        this.activeCarCaster = activeCarCaster;
        this.brandCode = brandCode;
        this.modelCode = modelCode;
        this.yearCode = yearCode;
    }

    public Vehicle(){

    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCasterDay() {
        return casterDay;
    }

    public void setCasterDay(String casterDay) {
        this.casterDay = casterDay;
    }

    public boolean isActiveCarCaster() {
        return activeCarCaster;
    }

    public void setActiveCarCaster(boolean activeCarCaster) {
        this.activeCarCaster = activeCarCaster;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getYearCode() {
        return yearCode;
    }

    public void setYearCode(String yearCode) {
        this.yearCode = yearCode;
    }

    @Override
    public String toString(){
        return this.brand + this.model + this.year + this.price + this.casterDay + this.activeCarCaster;
    }
}
