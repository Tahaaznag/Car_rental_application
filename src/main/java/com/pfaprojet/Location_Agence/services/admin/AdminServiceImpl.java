package com.pfaprojet.Location_Agence.services.admin;

import com.pfaprojet.Location_Agence.dto.CarDto;
import com.pfaprojet.Location_Agence.entity.Car;
import com.pfaprojet.Location_Agence.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final CarRepository carRepository;

    @Override
    public boolean postCar(CarDto carDto) throws IOException {
        try{
            Car car=new Car();
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(car.getColor());
            car.setPrice(carDto.getPrice());
            car.setYear(carDto.getYear());
            car.setType(carDto.getType());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());
            car.setImage(carDto.getImage().getBytes());
            carRepository.save(car);
            return  true;
        }catch(Exception e){
            return false;
        }



    }
}
