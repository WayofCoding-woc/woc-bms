package com.woc.bms.util;

import com.woc.bms.data.model.SeatAvailability;
import com.woc.bms.data.model.TicketBooking;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingUtil {

    public static List<SeatAvailability> sortSeatAvailabilitiesByCategory(List<SeatAvailability> seatAvailabilities) {
        return seatAvailabilities.stream()
                .sorted(Comparator.comparing(sa -> sa.getSeat().getSeatCategory().getCategoryName()))
                .collect(Collectors.toList());
    }
    public static List<TicketBooking> sortTicketsByCategory(List<TicketBooking> tickets) {
        return tickets.stream()
                .sorted(Comparator.comparing(t -> t.getSeat().getSeatCategory().getCategoryName()))
                .collect(Collectors.toList());
    }

}
