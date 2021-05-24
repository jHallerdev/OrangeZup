package br.com.vehicles.vehiclesapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.vehicles.vehiclesapi.model.FipeResponse;

@Service
@FeignClient(name = "FipeService", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeService {
    
    @GetMapping("/{type}/marcas")
    public List<FipeResponse> getBrands(@PathVariable String type);

    @GetMapping("/{type}/marcas/{brandCode}/modelos")
    public FipeResponse getModels(@PathVariable String type, @PathVariable String brandCode);

    @GetMapping("/{type}/marcas/{brandCode}/modelos/{modelCode}/anos")
    public List<FipeResponse> getYears(@PathVariable String type, @PathVariable String brandCode, @PathVariable String modelCode);

    @GetMapping("/{type}/marcas/{brandCode}/modelos/{modelCode}/anos/{year}")
    public Map<?,?> getPrice(@PathVariable String type, @PathVariable String brandCode, @PathVariable String modelCode, @PathVariable String year);
}
