package com.woc.bms.data.repository;

import com.woc.bms.data.model.SeatAvailability;
import com.woc.bms.data.model.ShowTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatAvailabilityRepository extends JpaRepository<SeatAvailability, Integer> {

    List<SeatAvailability> findByShowTime(ShowTime showTime);
}
