package com.woc.bms;

import com.woc.bms.data.model.City;
import com.woc.bms.data.model.Theatre;
import com.woc.bms.data.model.TicketBooking;
import com.woc.bms.data.repository.SeatAvailabilityRepository;
import com.woc.bms.data.repository.TheatreRepository;
import com.woc.bms.service.BookingService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WocBmsApplicationTests {
	@Autowired
	private TheatreRepository theatreRepository;

	@Autowired
	private SeatAvailabilityRepository seatAvailabilityRepository;

	@Autowired
	private BookingService bookingService;

	@Test
	void contextLoads() {
	}

	@Test
	public void init() {
		//testSaveTheatreData();
		//dataFetchTest();

		System.out.println("_____________________________");

		//testBooking();
		//concurrrentBookingTest();

	}

	private void concurrrentBookingTest() {
		Thread t1 = new Thread(() -> {
			testBooking();
		});

		Thread t2 = new Thread(() -> {
			testBooking();
		});

		t1.start();
		t2.start();
	}

	private void testBooking() {
		TicketBooking book = bookingService.book(2, 1);
		System.out.println("ticket has been booked successfully!");
		System.out.println(book);
	}

	private void dataFetchTest() {

		Theatre theatre = theatreRepository.findById(4).get();
		System.out.println(theatre);
		System.out.println("____________________________________");
		Theatre gpl = theatreRepository.findByTheatreCode("GPMS3");
		System.out.println(gpl);

		System.out.println("_____________________________________");
		Theatre gpms3 = theatreRepository.getTheatre("GPMS3");
		System.out.println(gpms3);

		System.out.println("+++++++++++++++++++++++++++++++++++++");
		List<Theatre> blrTheatres = theatreRepository.getTheatreByCityCode("BLR");
		System.out.println("blrTheatres.size()="+blrTheatres.size());
		blrTheatres.stream().forEach(System.out::println);
		System.out.println("fetched successfully!");
	}

	private void testSaveTheatreData() {
		Theatre theatre = new Theatre();
		//theatre.setId(1203);
		theatre.setTheatreCode("GPL");
		theatre.setTheatreName("Gopalan Cinema");

		City city = new City();
		//city.setId(10);
		city.setCityCode("BLR");
		city.setCityName("Bangalore");

		theatre.setCity(city);

		Theatre savedObject = theatreRepository.save(theatre);
		System.out.println("savedObject.getId()="+savedObject.getId());
	}

}
