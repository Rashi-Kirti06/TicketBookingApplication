CREATE DATABASE IF NOT EXISTS ticket_booking;

USE ticket_booking;


CREATE TABLE IF NOT EXISTS movies (

                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,

                                      title VARCHAR(150) NOT NULL,

    genre VARCHAR(80) NOT NULL,

    language VARCHAR(50) NOT NULL,

    duration_minutes INT NOT NULL
    );


CREATE TABLE IF NOT EXISTS shows (

                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,

                                     movie_id BIGINT NOT NULL,

                                     theatre VARCHAR(150) NOT NULL,

    show_time DATETIME NOT NULL,

    CONSTRAINT fk_show_movie

    FOREIGN KEY (movie_id)

    REFERENCES movies(id)
    );


CREATE TABLE IF NOT EXISTS bookings (

                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,

                                        customer_name VARCHAR(100) NOT NULL,

    show_id BIGINT NOT NULL,

    movie_title VARCHAR(150) NOT NULL,

    theatre VARCHAR(150) NOT NULL,

    seats VARCHAR(500) NOT NULL,

    total_amount DECIMAL(10,2) NOT NULL,

    status VARCHAR(30) NOT NULL,

    created_at DATETIME NOT NULL,

    CONSTRAINT fk_booking_show

    FOREIGN KEY (show_id)

    REFERENCES shows(id)
    );


CREATE TABLE IF NOT EXISTS booking_seats (

                                             id BIGINT PRIMARY KEY AUTO_INCREMENT,

                                             booking_id BIGINT NOT NULL,

                                             show_id BIGINT NOT NULL,

                                             seat_number VARCHAR(20) NOT NULL,

    status VARCHAR(20) NOT NULL,

    CONSTRAINT uq_show_seat

    UNIQUE(show_id, seat_number),

    CONSTRAINT fk_seat_booking

    FOREIGN KEY (booking_id)

    REFERENCES bookings(id),

    CONSTRAINT fk_seat_show

    FOREIGN KEY (show_id)

    REFERENCES shows(id)
    );