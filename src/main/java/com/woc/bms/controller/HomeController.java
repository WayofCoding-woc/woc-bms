package com.woc.bms.controller;

import com.woc.bms.data.model.Customer;
import com.woc.bms.data.model.SeatAvailability;
import com.woc.bms.data.model.TicketBooking;
import com.woc.bms.service.CustomerAuthDetails;
import com.woc.bms.service.DataService;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class HomeController {

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String redirectToIndexPage(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    private Customer getLoggedInCustomer() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomerAuthDetails) {
            CustomerAuthDetails customerAuthDetails = (CustomerAuthDetails) principal;
            return customerAuthDetails.getCustomer();
        }

        throw new IllegalStateException("Unable to get the Customer info from security principal");
    }

    @PostMapping("/home")
    public String forwardHome(ModelMap model, HttpServletRequest request){
        return home(model, request);
    }

    @GetMapping("/home")
    public String home(ModelMap model, HttpServletRequest request){
        log.info("home api has been triggered.");
        model.put("cities", dataService.getAllCity());

        HttpSession session = request.getSession(false);
        if(null != session){
            Customer loggedInCustomer = getLoggedInCustomer();
            session.setAttribute("customerName", loggedInCustomer.getName());
            session.setAttribute("customerId", loggedInCustomer.getId());
        }
        return "home";
    }

    @GetMapping("/theatres/city/{cityCode}")
    public String getTheatreByCityCode(@PathVariable("cityCode") String cityCode, ModelMap model){
        model.put("theatres", dataService.getTheatreByCityCode(cityCode));
        return "theatres";
    }

    @GetMapping("/showtime/theatre/{theatreCode}")
    public String getShowtimeByTheatreCode(@PathVariable("theatreCode") String theatreCode, ModelMap model){
        model.put("showtimes", dataService.getShowtimeByTheatreCode(theatreCode));
        return "showtimes";
    }

    @GetMapping("/seat/showtime/{showtimeId}")
    public String getSeatByShowtimeId(@PathVariable("showtimeId") Integer showtimeId, ModelMap model){
        List<SeatAvailability> seatAvailabilities = dataService.getSeatByShowtimeId(showtimeId);
        if(seatAvailabilities.isEmpty()){
            model.put("msg", "No seats configured for the selected showTime.");
            return "error";
        }
        model.put("seats", seatAvailabilities);
        SeatAvailability seatAvailability = seatAvailabilities.get(0);
        model.put("movieName", seatAvailability.getShowTime().getMovieName());
        model.put("showTime", seatAvailability.getShowTime().getShowTime());
        model.put("showDate", seatAvailability.getDate());
        model.put("theatreName", seatAvailability.getShowTime().getTheatre().getTheatreName());
        return "seatlayout";
    }

    @PostMapping("/cartSummary")
    public String getSeatByShowtimeId(ModelMap model, HttpServletRequest request){
        String seats_choosed = request.getParameter("seats_choosed");
        List<Integer> selectedAvailableSeatIds = Stream.of(seats_choosed.split(",")).filter(Predicate.not(String::isBlank)).map(Integer::valueOf).collect(Collectors.toList());
        List<SeatAvailability> seatAvailabilities = dataService.getSeatAvailabilityByIds(selectedAvailableSeatIds);
        if(seatAvailabilities.isEmpty()){
            model.put("msg", "Seat must be selected for booking, please try again");
            return "error";
        }

        model.put("seats_choosed", seats_choosed);
        SeatAvailability seatAvailability = seatAvailabilities.get(0);
        model.put("movieName", seatAvailability.getShowTime().getMovieName());
        model.put("showTime", seatAvailability.getShowTime().getShowTime());
        model.put("showDate", seatAvailability.getDate());
        model.put("theatreName", seatAvailability.getShowTime().getTheatre().getTheatreName());
        model.put("seatAvailabilities", seatAvailabilities);
        return "cart";
    }

    @PostMapping("/book")
    public String bookSeats(ModelMap model, HttpServletRequest request){
        String seats_choosed = request.getParameter("seats_choosed");
        List<Integer> selectedAvailableSeatIds = Stream.of(seats_choosed.split(",")).filter(Predicate.not(String::isBlank)).map(Integer::valueOf).collect(Collectors.toList());
        Integer customerId = Integer.valueOf(request.getParameter("customerId"));

        List<TicketBooking> ticketsBooking = dataService.bookSelectedSeats(selectedAvailableSeatIds, customerId);
        if(ticketsBooking.isEmpty()){
            model.put("msg", "Sorry! Could not book the tickets for you, please try again!");
            return "error";
        }

        model.put("ticketsBooking", ticketsBooking);
        TicketBooking ticketBooking = ticketsBooking.get(0);
        model.put("movieName", ticketBooking.getShowTime().getMovieName());
        model.put("showTime", ticketBooking.getShowTime().getShowTime());
        model.put("showDate", ticketBooking.getDate());
        model.put("theatreName", ticketBooking.getShowTime().getTheatre().getTheatreName());

        return "ticket";
    }


    @GetMapping("/ticketsHistory/{customerId}")
    public String getTicketsByCustomerId(@PathVariable("customerId") Integer customerId, ModelMap model){
        log.info("fetch ticket history api has been triggered for customerId={}", customerId);
        List<TicketBooking> ticketsBooking = dataService.getTicketsByCustomerId(customerId);
        if(ticketsBooking.isEmpty()){
            model.put("msg", "No tickets found for you");
            return "error";
        }
        model.put("ticketsBooking", ticketsBooking);
        TicketBooking ticketBooking = ticketsBooking.get(0);
        model.put("movieName", ticketBooking.getShowTime().getMovieName());
        model.put("showTime", ticketBooking.getShowTime().getShowTime());
        model.put("showDate", ticketBooking.getDate());
        model.put("theatreName", ticketBooking.getShowTime().getTheatre().getTheatreName());

        return "ticketsHistory";
    }

}
