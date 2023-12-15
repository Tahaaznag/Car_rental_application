package com.pfaprojet.Location_Agence.services.auth;

import com.pfaprojet.Location_Agence.dto.SignupRequest;
import com.pfaprojet.Location_Agence.dto.UserDto;

public interface AuthService {
    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);
}
