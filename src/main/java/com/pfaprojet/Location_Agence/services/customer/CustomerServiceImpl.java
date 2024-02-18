package com.pfaprojet.Location_Agence.services.customer;

import com.pfaprojet.Location_Agence.dto.BookACarDto;
import com.pfaprojet.Location_Agence.dto.CarDto;
import com.pfaprojet.Location_Agence.dto.CarDtoListDto;
import com.pfaprojet.Location_Agence.dto.SearchCarDto;
import com.pfaprojet.Location_Agence.entity.BookACar;
import com.pfaprojet.Location_Agence.entity.Car;
import com.pfaprojet.Location_Agence.entity.User;
import com.pfaprojet.Location_Agence.enums.BookCarStatus;
import com.pfaprojet.Location_Agence.repository.BookACarRepository;
import com.pfaprojet.Location_Agence.repository.CarRepository;
import com.pfaprojet.Location_Agence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final BookACarRepository bookACarRepository;
    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
        Optional<Car> optionalCar=carRepository.findById(bookACarDto.getCarId());
        Optional<User> optionalUser=userRepository.findById(bookACarDto.getUserId());
        if(optionalCar.isPresent() && optionalUser.isPresent()){
            Car existingCar= optionalCar.get();
            BookACar bookACar=new BookACar();
            bookACar.setUser(optionalUser.get());
            bookACar.setCar(existingCar);
            bookACar.setBookCarStatus(BookCarStatus.PENDING);
            long diffInMilliSeconds=bookACarDto.getToDate().getTime()-bookACarDto.getFromDate().getTime();
            long days= TimeUnit.MICROSECONDS.toDays(diffInMilliSeconds);
            bookACar.setDays(days);
            bookACar.setPrice(existingCar.getPrice()*days);
            bookACarRepository.save(bookACar);
            return true;
        }
        return false;
    }

    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar=carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public List<BookACarDto> getBookingsByUserId(Long userId) {
        List<BookACar> bookings = bookACarRepository.findAllByUserId(userId);
        return bookings.stream()
                .map(BookACar::getBookACarDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car=new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());
        car.setColor(searchCarDto.getColor());
        ExampleMatcher exampleMatcher=
                ExampleMatcher.matchingAll()
                        .withMatcher("brand",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("transmission",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("color",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<Car> carExample=Example.of(car,exampleMatcher);
        List<Car> carList=carRepository.findAll(carExample);
        CarDtoListDto carDtoListDto=new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carDtoListDto;
    }

}
