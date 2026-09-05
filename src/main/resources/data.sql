USE ticket_booking;
INSERT INTO movies
(
    title,
    genre,
    language,
    duration_minutes
)

SELECT
    'Interstellar',
    'Sci-Fi',
    'English',
    169

    WHERE NOT EXISTS
(
    SELECT 1
    FROM movies
    WHERE title = 'Interstellar'
);


INSERT INTO movies
(
    title,
    genre,
    language,
    duration_minutes
)

SELECT
    'Inception',
    'Sci-Fi',
    'English',
    148

    WHERE NOT EXISTS
(
    SELECT 1
    FROM movies
    WHERE title = 'Inception'
);


INSERT INTO shows
(
    movie_id,
    theatre,
    show_time
)

SELECT
    id,
    'PVR Cinemas',
    DATE_ADD(NOW(), INTERVAL 1 DAY)

FROM movies

WHERE title = 'Interstellar'

  AND NOT EXISTS
    (
        SELECT 1
        FROM shows
        WHERE theatre = 'PVR Cinemas'
    );


INSERT INTO shows
(
    movie_id,
    theatre,
    show_time
)

SELECT
    id,
    'INOX',
    DATE_ADD(NOW(), INTERVAL 2 DAY)

FROM movies

WHERE title = 'Inception'

  AND NOT EXISTS
    (
        SELECT 1
        FROM shows
        WHERE theatre = 'INOX'
    );