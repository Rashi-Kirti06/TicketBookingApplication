package com.ticketbooking.repository;

import com.ticketbooking.model.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {
    private final JdbcTemplate jdbc;
    public BookingRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public int save(Booking booking) {

        return jdbc.update(
                """
                INSERT INTO bookings
                (
                    customer_name,
                    show_id,
                    movie_title,
                    theatre,
                    seats,
                    total_amount,
                    status,
                    created_at
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """,

                booking.getCustomerName(),
                booking.getShowId(),
                booking.getMovieTitle(),
                booking.getTheatre(),
                booking.getSeats(),
                booking.getTotalAmount(),
                booking.getStatus(),
                booking.getCreatedAt()
        );
    }

    public Long findLastBookingId() {

        return jdbc.queryForObject(
                "SELECT LAST_INSERT_ID()",
                Long.class
        );
    }

    public boolean seatAlreadyBooked(
            Long showId,
            String seat
    ) {

        Integer count = jdbc.queryForObject(
                """
                SELECT COUNT(*)
                FROM booking_seats
                WHERE show_id = ?
                AND seat_number = ?
                AND status = 'BOOKED'
                """,

                Integer.class,

                showId,
                seat
        );

        return count != null && count > 0;
    }

    public void saveSeat(
            Long bookingId,
            Long showId,
            String seat
    ) {

        jdbc.update(
                """
                INSERT INTO booking_seats
                (
                    booking_id,
                    show_id,
                    seat_number,
                    status
                )
                VALUES (?, ?, ?, 'BOOKED')
                """,

                bookingId,
                showId,
                seat
        );
    }

    public List<Booking> findAll() {

        return jdbc.query(
                """
                SELECT
                    id,
                    customer_name,
                    show_id,
                    movie_title,
                    theatre,
                    seats,
                    total_amount,
                    status,
                    created_at
                FROM bookings
                ORDER BY id DESC
                """,

                (rs, rowNum) ->
                        new Booking(
                                rs.getLong("id"),
                                rs.getString("customer_name"),
                                rs.getLong("show_id"),
                                rs.getString("movie_title"),
                                rs.getString("theatre"),
                                rs.getString("seats"),
                                rs.getDouble("total_amount"),
                                rs.getString("status"),
                                rs.getTimestamp("created_at")
                                        .toLocalDateTime()
                        )
        );
    }
}