package com.ticketbooking.repository;

import com.ticketbooking.model.Show;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class ShowRepository {
    private final JdbcTemplate jdbc;
    public ShowRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    public List<Show> findAll() {
        return jdbc.query(
                """
                SELECT
                    s.id,
                    s.movie_id,
                    m.title,
                    s.theatre,
                    s.show_time
                FROM shows s
                JOIN movies m
                    ON s.movie_id = m.id
                ORDER BY s.show_time """,
                (rs, rowNum) -> new Show(
                        rs.getLong("id"),
                        rs.getLong("movie_id"),
                        rs.getString("title"),
                        rs.getString("theatre"),
                        rs.getTimestamp("show_time")
                                .toLocalDateTime()));
    }
    public Show findById(Long id) {
        return jdbc.queryForObject(
                """
                SELECT
                    s.id,
                    s.movie_id,
                    m.title,
                    s.theatre,
                    s.show_time
                FROM shows s
                JOIN movies m
                    ON s.movie_id = m.id
                WHERE s.id = ?""",
                (rs, rowNum) -> new Show(
                        rs.getLong("id"),
                        rs.getLong("movie_id"),
                        rs.getString("title"),
                        rs.getString("theatre"),
                        rs.getTimestamp("show_time")
                                .toLocalDateTime()
                        ), id );
    }

    public int save( Long movieId, String theatre, Timestamp showTime) {
        return jdbc.update(
                """
                INSERT INTO shows
                (movie_id, theatre, show_time)
                VALUES (?, ?, ?)
                """,
                movieId,
                theatre,
                showTime
        );
    }
}