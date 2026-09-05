package com.ticketbooking.controller;

import com.ticketbooking.exception.BookingException;
import com.ticketbooking.service.BookingService;
import com.ticketbooking.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final ShowService showService;

    public BookingController(
            BookingService bookingService,
            ShowService showService
    ) {
        this.bookingService = bookingService;
        this.showService = showService;
    }

    @GetMapping("/book/{showId}")
    public String bookPage(
            @PathVariable Long showId,
            Model model
    ) {

        model.addAttribute(
                "show",
                showService.getShow(showId)
        );

        return "booking";
    }

    @PostMapping("/book")
    public String book(
            @RequestParam String customerName,
            @RequestParam Long showId,
            @RequestParam String seats,
            Model model
    ) {

        try {

            model.addAttribute(
                    "booking",
                    bookingService.book(
                            customerName,
                            showId,
                            seats
                    )
            );

            return "booking-success";

        } catch (BookingException ex) {

            model.addAttribute(
                    "error",
                    ex.getMessage()
            );

            model.addAttribute(
                    "show",
                    showService.getShow(showId)
            );

            return "booking";
        }
    }

    @GetMapping("/bookings")
    public String bookings(Model model) {

        model.addAttribute(
                "bookings",
                bookingService.getAllBookings()
        );

        return "bookings";
    }

}