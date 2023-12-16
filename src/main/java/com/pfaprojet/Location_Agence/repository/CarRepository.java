package com.pfaprojet.Location_Agence.repository;

import com.pfaprojet.Location_Agence.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
