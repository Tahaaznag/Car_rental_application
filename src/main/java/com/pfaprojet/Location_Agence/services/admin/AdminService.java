package com.pfaprojet.Location_Agence.services.admin;

import com.pfaprojet.Location_Agence.dto.CarDto;

import java.io.IOException;

public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;
}
