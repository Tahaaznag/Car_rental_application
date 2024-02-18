package com.pfaprojet.Location_Agence.dto;

import com.pfaprojet.Location_Agence.enums.BookCarStatus;
import lombok.Data;

import java.util.Date;
@Data
public class BookACarDto {
    private Long id;
    private Date fromDate;
    private Date toDate;
    private Long days;
    private Long price;
    private BookCarStatus bookCarStatus;
    private Long carId;
    private Long userId;
    private String email;
    private String username;
}
