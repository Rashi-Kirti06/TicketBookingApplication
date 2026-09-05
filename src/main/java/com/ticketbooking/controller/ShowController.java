package com.ticketbooking.controller;

import com.ticketbooking.service.MovieService;
import com.ticketbooking.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShowController {

    private final ShowService showService;
    private final MovieService movieService;

    public ShowController(
            ShowService showService,
            MovieService movieService
    ) {
        this.showService = showService;
        this.movieService = movieService;
    }

    @GetMapping("/shows")
    public String shows(Model model) {

        model.addAttribute(
                "shows",
                showService.getAllShows()
        );

        return "shows";
    }

    @GetMapping("/shows/add")
    public String addShowPage(Model model) {

        model.addAttribute(
                "movies",
                movieService.getAllMovies()
        );

        return "add-show";
    }

    @PostMapping("/shows/add")
    public String addShow(
            @RequestParam Long movieId,
            @RequestParam String theatre,
            @RequestParam String showTime
    ) {

        showService.addShow(
                movieId,
                theatre,
                showTime
        );

        return "redirect:/shows";
    }
}