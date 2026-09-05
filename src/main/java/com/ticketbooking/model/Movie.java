package com.ticketbooking.model;

public class Movie {
    private Long id;
    private String title;
    private String genre;
    private String language;
    private int durationMinutes;

    public Movie(){
    }
    public Movie(Long id, String title, String genre, String language, int durationMinutes){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.durationMinutes = durationMinutes;
    }
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }

    public String getGenre(){ return genre; }
    public void setGenre(String genre){ this.genre = genre; }

    public String getLanguage(){ return language; }
    public void setLanguage(String language){ this.language = language; }

    public int getDurationMinutes(){ return durationMinutes; }
    public void setDurationMinutes(int durationMinutes){ this.durationMinutes = durationMinutes; }

}
