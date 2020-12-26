package com.woc.bms.service;

import com.woc.bms.dao.DataDao;
import com.woc.bms.data.model.City;
import com.woc.bms.data.model.Customer;
import com.woc.bms.data.model.SeatAvailability;
import com.woc.bms.data.model.ShowTime;
import com.woc.bms.data.model.Theatre;
import com.woc.bms.data.model.TicketBooking;
import com.woc.bms.data.repository.CustomerRepository;
import com.woc.bms.data.repository.SeatAvailabilityRepository;
import com.woc.bms.data.repository.ShowTimeRepository;
import com.woc.bms.data.repository.TheatreRepository;
import com.woc.bms.data.repository.TicketBookingRepository;
import com.woc.bms.util.SortingUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired private DataDao dataDao;
    @Autowired private TheatreRepository theatreRepository;
    @Autowired private ShowTimeRepository showTimeRepository;
    @Autowired private SeatAvailabilityRepository seatAvailabilityRepository;
    @Autowired private BookingService bookingService;
    @Autowired private TicketBookingRepository ticketBookingRepository;
    @Autowired private CustomerRepository customerRepository;


    public List<City> getAllCity() {
        return dataDao.getAllCity();
    }

    public List<Theatre> getTheatreByCityCode(String cityCode){
        List<Theatre> theatres = theatreRepository.getTheatreByCityCode(cityCode);
        List<Theatre> collect = theatres.stream().map(t -> {
            Theatre t1 = new Theatre();
            t1.setTheatreName(t.getTheatreName());
            t1.setTheatreCode(t.getTheatreCode());
            return t1;
        }).collect(Collectors.toList());
        return collect;
    }

    public List<ShowTime> getShowtimeByTheatreCode(String theatreCode) {
        return theatreRepository.getTheatre(theatreCode).getShowTimes();
    }

    public List<SeatAvailability> getSeatByShowtimeId(Integer showtimeId) {
        ShowTime showTime = showTimeRepository.findById(showtimeId).get();
        List<SeatAvailability> seatAvailabilities = seatAvailabilityRepository.findByShowTime(showTime);
        return SortingUtil.sortSeatAvailabilitiesByCategory(seatAvailabilities);
    }

    public List<SeatAvailability> getSeatAvailabilityByIds(List<Integer> ids) {
        return SortingUtil.sortSeatAvailabilitiesByCategory(seatAvailabilityRepository.findAllById(ids));
    }

    public List<TicketBooking> bookSelectedSeats(List<Integer> selectedAvailableSeatIds, Integer customerId) {
        return SortingUtil.sortTicketsByCategory(selectedAvailableSeatIds.stream().map(s -> bookingService.book(s, customerId)).collect(Collectors.toList()));
    }

    public List<TicketBooking> getTicketsByCustomerId(Integer customerId){
        Customer customer = customerRepository.findById(customerId).get();
        return SortingUtil.sortTicketsByCategory(ticketBookingRepository.findByCustomer(customer));
    }

}
