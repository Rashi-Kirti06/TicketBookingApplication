package com.ticketbooking.model;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private String customerName;
    private Long showId;
    private String movieTitle;
    private String theatre;
    private String seats;
    private double totalAmount;
    private String status;
    private LocalDateTime createdAt;

    public Booking() {
    }

    public Booking(
            Long id,
            String customerName,
            Long showId,
            String movieTitle,
            String theatre,
            String seats,
            double totalAmount,
            String status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.customerName = customerName;
        this.showId = showId;
        this.movieTitle = movieTitle;
        this.theatre = theatre;
        this.seats = seats;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getCustomerName() {return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public Long getShowId() {return showId;}
    public void setShowId(Long showId) {this.showId = showId;}
    public String getMovieTitle() {return movieTitle;}
    public void setMovieTitle(String movieTitle) {this.movieTitle = movieTitle;}
    public String getTheatre() {return theatre;}
    public void setTheatre(String theatre) {this.theatre = theatre;}
    public String getSeats() {return seats;}
    public void setSeats(String seats) {this.seats = seats;}
    public double getTotalAmount() {return totalAmount;}
    public void setTotalAmount(double totalAmount) {this.totalAmount = totalAmount;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
}