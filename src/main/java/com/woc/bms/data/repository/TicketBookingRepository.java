package com.woc.bms.data.repository;

import com.woc.bms.data.model.Customer;
import com.woc.bms.data.model.TicketBooking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long> {
    List<TicketBooking> findByCustomer(Customer customer);

}
