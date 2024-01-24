package com.pfaprojet.Location_Agence.controller;

import com.pfaprojet.Location_Agence.dto.CarDto;
import com.pfaprojet.Location_Agence.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars(){
        List<CarDto> carDtoList=customerService.getAllCars();
        return ResponseEntity.ok(carDtoList);
    }
}
