package com.woc.bms.service;

import com.woc.bms.data.model.Customer;
import com.woc.bms.data.model.SeatAvailability;
import com.woc.bms.data.model.TicketBooking;
import com.woc.bms.data.repository.CustomerRepository;
import com.woc.bms.data.repository.SeatAvailabilityRepository;
import com.woc.bms.data.repository.TicketBookingRepository;
import com.woc.bms.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
public class BookingService {
    @Autowired
    private SeatAvailabilityRepository seatAvailabilityRepository;

    @Autowired
    private TicketBookingRepository ticketBookingRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Transactional
    public TicketBooking book(Integer seatAvailabilityId, Integer customerId){
        SeatAvailability seatAvailability = seatAvailabilityRepository.findById(seatAvailabilityId).get();//N6
        if(Boolean.FALSE.equals(seatAvailability.getAvailable())){
            throw new IllegalStateException("Sorry selected seat is not available, please try again");
        }

        TicketBooking ticketIternary = new TicketBooking();
        ticketIternary.setDate(seatAvailability.getDate());
        ticketIternary.setSeat(seatAvailability.getSeat());
        ticketIternary.setShowTime(seatAvailability.getShowTime());
        ticketIternary.setTicketReferenceNumber("woc-mov-tkt-"+ AppUtil.generateRandomNumber());
        ticketIternary.setCreatedDate(new Date());

        Customer customer = customerRepository.findById(customerId).get();
        System.out.println(customer);

        ticketIternary.setCustomer(customer);

        System.out.println(seatAvailability);


        seatAvailability.setAvailable(false);//update
        seatAvailabilityRepository.save(seatAvailability);//update into db

        TicketBooking createdTicket = ticketBookingRepository.save(ticketIternary);//create ticket

        return createdTicket;
    }
}
