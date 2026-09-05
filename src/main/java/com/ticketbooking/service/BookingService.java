//package com.ticketbooking.service;
//
//import com.ticketbooking.exception.BookingException;
//import com.ticketbooking.model.Booking;
//import com.ticketbooking.model.Show;
//import com.ticketbooking.repository.BookingRepository;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class BookingService {
//
//    private static final double SEAT_PRICE = 250.0;
//
//    private final BookingRepository bookingRepository;
//    private final ShowService showService;
//
//    public BookingService(
//            BookingRepository bookingRepository,
//            ShowService showService,
//    ) {
//        this.bookingRepository = bookingRepository;
//        this.showService = showService;
//    }
//
//    @Transactional
//    public Booking book(
//            String customerName,
//            Long showId,
//            String seatCsv
//    ) {
//
//        Show show = showService.getShow(showId);
//
//        if (show == null) {
//            throw new BookingException(
//                    "Show not found"
//            );
//        }
//
//        List<String> seats =
//                Arrays.stream(seatCsv.split(","))
//                        .map(String::trim)
//                        .filter(s -> !s.isBlank())
//                        .distinct()
//                        .toList();
//
//        if (seats.isEmpty()) {
//            throw new BookingException(
//                    "Select at least one seat"
//            );
//        }
//
//        for (String seat : seats) {
//
//            if (bookingRepository.seatAlreadyBooked(
//                    showId,
//                    seat
//            )) {
//
//                throw new BookingException(
//                        "Seat already booked: " + seat
//                );
//            }
//        }
//
//        double totalAmount =
//                seats.size() * SEAT_PRICE;
//
//        Booking booking =
//                new Booking(
//                        null,
//                        customerName,
//                        showId,
//                        show.getMovieTitle(),
//                        show.getTheatre(),
//                        String.join(", ", seats),
//                        totalAmount,
//                        "CONFIRMED",
//                        LocalDateTime.now()
//                );
//
//        try {
//
//            bookingRepository.save(booking);
//
//            Long bookingId =
//                    bookingRepository.findLastBookingId();
//
//            for (String seat : seats) {
//
//                bookingRepository.saveSeat(
//                        bookingId,
//                        showId,
//                        seat
//                );
//            }
//
//            booking.setId(bookingId);
//            return booking;
//
//        } catch (DataIntegrityViolationException ex) {
//
//            throw new BookingException(
//                    "Booking conflict. Please choose different seats."
//            );
//        }
//    }
//
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//}

package com.ticketbooking.service;

import com.ticketbooking.exception.BookingException;
import com.ticketbooking.model.Booking;
import com.ticketbooking.model.Show;
import com.ticketbooking.repository.BookingRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class BookingService {

    private static final double SEAT_PRICE = 250.0;

    private final BookingRepository bookingRepository;
    private final ShowService showService;

    public BookingService(
            BookingRepository bookingRepository,
            ShowService showService
    ) {
        this.bookingRepository = bookingRepository;
        this.showService = showService;
    }

    @Transactional
    public Booking book(
            String customerName,
            Long showId,
            String seatCsv
    ) {

        Show show = showService.getShow(showId);

        if (show == null) {
            throw new BookingException(
                    "Show not found"
            );
        }

        List<String> seats =
                Arrays.stream(seatCsv.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isBlank())
                        .distinct()
                        .toList();

        if (seats.isEmpty()) {
            throw new BookingException(
                    "Select at least one seat"
            );
        }

        for (String seat : seats) {

            if (bookingRepository.seatAlreadyBooked(
                    showId,
                    seat
            )) {

                throw new BookingException(
                        "Seat already booked: " + seat
                );
            }
        }

        double totalAmount =
                seats.size() * SEAT_PRICE;

        Booking booking =
                new Booking(
                        null,
                        customerName,
                        showId,
                        show.getMovieTitle(),
                        show.getTheatre(),
                        String.join(", ", seats),
                        totalAmount,
                        "CONFIRMED",
                        LocalDateTime.now()
                );

        try {

            bookingRepository.save(booking);

            Long bookingId =
                    bookingRepository.findLastBookingId();

            for (String seat : seats) {

                bookingRepository.saveSeat(
                        bookingId,
                        showId,
                        seat
                );
            }

            booking.setId(bookingId);

            return booking;

        } catch (DataIntegrityViolationException ex) {

            throw new BookingException(
                    "Booking conflict. Please choose different seats."
            );
        }
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}