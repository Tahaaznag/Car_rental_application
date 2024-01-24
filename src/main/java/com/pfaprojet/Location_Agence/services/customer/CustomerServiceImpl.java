package com.pfaprojet.Location_Agence.services.customer;

import com.pfaprojet.Location_Agence.dto.CarDto;
import com.pfaprojet.Location_Agence.entity.Car;
import com.pfaprojet.Location_Agence.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CarRepository carRepository;
    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }
}
