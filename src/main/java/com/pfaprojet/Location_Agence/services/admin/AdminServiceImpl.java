package com.pfaprojet.Location_Agence.services.admin;

import com.pfaprojet.Location_Agence.dto.CarDto;
import com.pfaprojet.Location_Agence.entity.Car;
import com.pfaprojet.Location_Agence.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            car.setYear(carDto.getYear());
            car.setType(carDto.getType());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());
            car.setImage(carDto.getImage().getBytes());
            carRepository.save(car);
            return  true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }



    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car> optionalCar=carRepository.findById(id);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public boolean updateCar(Long carId, CarDto carDto) throws IOException {
        try {
            Optional<Car> optionalCar = carRepository.findById(carId);
            if (optionalCar.isPresent()) {
                Car existingCar = optionalCar.get();
                if (carDto.getImage() != null)
                    existingCar.setImage(carDto.getImage().getBytes());
                existingCar.setPrice(carDto.getPrice());
                existingCar.setYear(carDto.getYear());
                existingCar.setType(carDto.getType());
                existingCar.setTransmission(carDto.getTransmission());
                existingCar.setColor(carDto.getColor());
                existingCar.setName(carDto.getName());
                existingCar.setBrand(carDto.getBrand());
                carRepository.save(existingCar);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            // Handle the exception here, e.g., log it or print a message
            System.out.println("Exception while updating car: " + e.getMessage());
            return false;
        }
    }
}
