package com.ticketbooking.service;

import com.ticketbooking.model.Show;
import com.ticketbooking.repository.ShowRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ShowService {
    private final ShowRepository repository;
    public ShowService(ShowRepository repository) { this.repository = repository; }
    public List<Show> getAllShows() { return repository.findAll(); }
    public Show getShow(Long id) { return repository.findById(id); }
//    public void addShow( Long movieId, String theatre, String showTime) {
//        repository.save( movieId, theatre, Timestamp.valueOf(
//                        showTime.replace("T", " "))
//        );
//    }

    public void addShow(Long movieId, String theatre, String showTime) {
        LocalDateTime dateTime = LocalDateTime.parse(showTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        repository.save(movieId, theatre, Timestamp.valueOf(dateTime));
    }

}