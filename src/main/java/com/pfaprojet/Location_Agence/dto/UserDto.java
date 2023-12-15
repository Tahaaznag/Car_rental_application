package com.pfaprojet.Location_Agence.dto;

import com.pfaprojet.Location_Agence.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private  Long id;
    private String name;
    private String email;
    private UserRole userRole;
}
