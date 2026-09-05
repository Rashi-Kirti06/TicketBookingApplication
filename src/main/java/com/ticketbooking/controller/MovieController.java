//package com.ticketbooking.controller;
//
//import com.ticketbooking.model.Movie;
//import com.ticketbooking.service.MovieService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@Controller
//public class MovieController {
//    private final MovieService movieService;
//    public MovieController(MovieService movieService){ this.movieService = movieService; }
//    @GetMapping("/movies")
//    public String movies(Model model){
//        model.addAttribute("movies", movieService.getAllMovies());
//        return "movies";
//    }
//    @GetMapping("/movies/add")
//    public String addMovie(@ModelAttribute Movie movie){
//        movieService.addMovie(movie);
//        return "redirect:/movies";
//    }
//}

package com.ticketbooking.controller;

import com.ticketbooking.model.Movie;
import com.ticketbooking.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String movies(Model model) {

        model.addAttribute(
                "movies",
                movieService.getAllMovies()
        );

        return "movies";
    }

    @GetMapping("/movies/add")
    public String addMoviePage() {

        return "add-movie";
    }

    @PostMapping("/movies/add")
    public String addMovie(@ModelAttribute Movie movie) {

        movieService.addMovie(movie);

        return "redirect:/movies";
    }
}