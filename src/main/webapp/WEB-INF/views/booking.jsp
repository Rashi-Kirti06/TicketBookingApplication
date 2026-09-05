<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <title>Book Ticket</title>

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

    <h1>Book Ticket</h1>

    <%
        if (request.getAttribute("error") != null) {
    %>

    <div class="error">

        <%= request.getAttribute("error") %>

    </div>

    <%
        }
    %>

    <div class="card">

        <h2>
            ${show.movieTitle}
        </h2>

        <p>
            Theatre:
            ${show.theatre}
        </p>

        <p>
            Time:
            ${show.showTime}
        </p>

        <p>
            Price per seat:
            ₹250
        </p>

    </div>

    <form
            method="post"
            action="/book"
    >

        <input
                type="hidden"
                name="showId"
                value="${show.id}"
        >

        <input
                name="customerName"
                placeholder="Your name"
                required
        >

        <input
                name="seats"
                placeholder="A1, A2, B1"
                required
        >

        <button type="submit">
            Confirm Booking
        </button>

    </form>

</main>

</body>

</html>