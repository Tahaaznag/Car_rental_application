package com.pfaprojet.Location_Agence.services.customer;

import com.pfaprojet.Location_Agence.dto.BookACarDto;
import com.pfaprojet.Location_Agence.dto.CarDto;
import com.pfaprojet.Location_Agence.dto.CarDtoListDto;
import com.pfaprojet.Location_Agence.dto.SearchCarDto;

import java.util.List;

public interface CustomerService {
    List<CarDto> getAllCars();
    boolean bookACar(BookACarDto bookACarDto);
    CarDto getCarById(Long carId);
    List<BookACarDto> getBookingsByUserId(Long userId);
    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
