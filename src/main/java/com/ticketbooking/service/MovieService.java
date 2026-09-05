package com.ticketbooking.service;

import com.ticketbooking.model.Movie;
import com.ticketbooking.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;
    public MovieService(MovieRepository repository){ this.repository = repository; }
    public List<Movie> getAllMovies(){ return repository.findAll(); }
    public Movie getMovie(Long id){ return repository.findById(id); }
    public void addMovie(Movie movie){ repository.save(movie); }
}
