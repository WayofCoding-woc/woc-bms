package com.woc.bms.data.repository;

import com.woc.bms.data.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
