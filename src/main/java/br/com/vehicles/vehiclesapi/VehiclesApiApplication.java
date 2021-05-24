package br.com.vehicles.vehiclesapi;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("br.com.vehicles.vehiclesapi.model")
@EnableJpaRepositories("br.com.vehicles.vehiclesapi.repository")
@EnableFeignClients
public class VehiclesApiApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(VehiclesApiApplication.class, args);

	}
}
