package com.pfaprojet.Location_Agence.services.admin;

import com.pfaprojet.Location_Agence.dto.BookACarDto;
import com.pfaprojet.Location_Agence.dto.CarDto;
import com.pfaprojet.Location_Agence.dto.CarDtoListDto;
import com.pfaprojet.Location_Agence.dto.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;
    List<CarDto>getAllCars();
    void deleteCar(Long id);
    CarDto getCarById(Long id);
    boolean updateCar(Long carId, CarDto carDto) throws IOException;
    List<BookACarDto> getBookings();
    boolean changeBookingStatus(Long bookingId,String status);
    CarDtoListDto searchCar(SearchCarDto searchCarDto);
}
