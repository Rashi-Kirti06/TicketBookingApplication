package com.ticketbooking.model;

import java.time.LocalDateTime;

public class Show {
    private Long id;
    private Long movieId;
    private String movieTitle;
    private String theatre;
    private LocalDateTime showTime;

    public Show(){
    }
    public Show(Long id, Long movieId, String movieTitle, String theatre, LocalDateTime showTime){
        this.id = id;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.theatre = theatre;
        this.showTime = showTime;
    }
    public Long getId(){ return id; }
    public Long getMovieId(){ return movieId; }
    public String getMovieTitle(){ return movieTitle; }
    public String getTheatre(){ return theatre; }
    public LocalDateTime getShowTime(){ return showTime; }
    public void setId(Long id){ this.id = id; }
    public void setMovieId(Long movieId){ this.movieId = movieId; }
    public void setMovieTitle(String movieTitle){ this.movieTitle = movieTitle; }
    public void setTheatre(String theatre){ this.theatre = theatre; }
    public void setShowTime(LocalDateTime showTime){ this.showTime = showTime; }

}
