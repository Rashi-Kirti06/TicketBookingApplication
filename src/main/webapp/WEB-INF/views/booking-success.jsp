<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <title>Booking Confirmed</title>

    <link
            rel="stylesheet"
            href="/css/style.css"
    >

</head>

<body>

<nav>

    <a href="/">Home</a>

    <a href="/movies">Movies</a>

    <a href="/shows">Shows</a>

    <a href="/bookings">Bookings</a>

</nav>

<main class="container">

    <div class="success">

        <h1>
            Booking Confirmed
        </h1>

        <p>
            Booking ID:
            ${booking.id}
        </p>

        <p>
            Customer:
            ${booking.customerName}
        </p>

        <p>
            Movie:
            ${booking.movieTitle}
        </p>

        <p>
            Theatre:
            ${booking.theatre}
        </p>

        <p>
            Seats:
            ${booking.seats}
        </p>

        <p>
            Total:
            ₹${booking.totalAmount}
        </p>

        <p>
            Status:
            ${booking.status}
        </p>

    </div>

</main>

</body>

</html>