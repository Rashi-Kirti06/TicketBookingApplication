package com.ticketbooking.repository;


import com.ticketbooking.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    private final JdbcTemplate jdbc;
    public MovieRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    public List<Movie> findAll(){
        return jdbc.query(""" 
                SELECT id, title, genre, language, duration_minutes FROM movies ORDER BY id""",
                (rs,rowNum) -> new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("language"),
                        rs.getInt("duration_minutes")
                ));
    }
    public Movie findById(Long id){
        return jdbc.queryForObject(""" 
                SELECT id, title, genre, language, duration_minutes FROM movies WHERE id  =?""",
                (rs,rowNum) -> new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("language"),
                        rs.getInt("duration_minutes")
                ), id );
    }
    public int save (Movie movie){
        return jdbc.update("""
                INSERT INTO movies(title, genre, language, duration_minutes) VALUES (?, ?, ?, ?)""",
                movie.getTitle(),
                movie.getGenre(),
                movie.getLanguage(),
                movie.getDurationMinutes());
    }
}
