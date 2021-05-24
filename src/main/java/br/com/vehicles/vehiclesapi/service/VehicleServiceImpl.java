package br.com.vehicles.vehiclesapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vehicles.vehiclesapi.model.FipeResponse;
import br.com.vehicles.vehiclesapi.model.User;
import br.com.vehicles.vehiclesapi.model.Vehicle;
import br.com.vehicles.vehiclesapi.repository.UserRepository;
import br.com.vehicles.vehiclesapi.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private FipeService fipeService;

    @Override
    public ResponseEntity<String> save(Vehicle vehicle, String email, String cpf){
        try{
            User user = userRepository.getUserByEmailAndCpf(email, cpf);

            setVehiclePrice(vehicle);
            setVehicleCasterDay(vehicle);
            setVehicleActiveCarCaster(vehicle);

            vehicle.setUser(user);
            vehicleRepository.save(vehicle);

            return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle created sucessfuly!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot save vehicle. Revise your data!");
        }
    }

    public void setVehiclePrice(Vehicle vehicle){
 
        List<FipeResponse> fipeBrands = new ArrayList<FipeResponse>();
        FipeResponse fipeModels = new FipeResponse();
        List<FipeResponse> fipeYears = new ArrayList<FipeResponse>();

        fipeBrands = fipeService.getBrands(vehicle.getType());
        fipeBrands.forEach(f ->{
            if(f.getNome().equals(vehicle.getBrand())){
                vehicle.setBrandCode(f.getCodigo());
            }
        });
        
        fipeModels = fipeService.getModels(vehicle.getType(), vehicle.getBrandCode());
        fipeModels.getModelos().forEach(f ->{
           if(f.getNome().equals(vehicle.getModel())){
                vehicle.setModelCode(f.getCodigo());
            }
        });

        fipeYears = fipeService.getYears(vehicle.getType(), vehicle.getBrandCode(), vehicle.getModelCode());
        fipeYears.forEach(f ->{
            if(f.getNome().equals(vehicle.getYear())){
                vehicle.setYearCode(f.getCodigo());
            }
        });

        Map<?, ?> price = fipeService.getPrice(vehicle.getType(), vehicle.getBrandCode(), vehicle.getModelCode(), vehicle.getYearCode());
        vehicle.setPrice(price.get("Valor").toString().substring(3, price.get("Valor").toString().length()));
    }

    public void setVehicleCasterDay(Vehicle vehicle){
        String casterDay;
        char lastYearDigit = vehicle.getYear().charAt(3);
        
        if(lastYearDigit == '0' || lastYearDigit == '1'){
            casterDay = "MONDAY";
        }
        else if(lastYearDigit == '2' || lastYearDigit == '3'){
            casterDay = "TUESDAY";
        }
        else if(lastYearDigit == '4' || lastYearDigit == '5'){
            casterDay = "WEDNESDAY";
        }
        else if(lastYearDigit == '6' || lastYearDigit == '7'){
            casterDay = "THURSDAY";
        }
        else if(lastYearDigit == '8' || lastYearDigit == '9'){
            casterDay = "FRIDAY";
        }
        else{
            casterDay = null;
        }

        vehicle.setCasterDay(casterDay);
    }

    public void setVehicleActiveCarCaster(Vehicle vehicle){
        if(LocalDateTime.now().getDayOfWeek().name().equals(vehicle.getCasterDay())){
            vehicle.setActiveCarCaster(true);
        }else{
            vehicle.setActiveCarCaster(false);
        }
    }
}