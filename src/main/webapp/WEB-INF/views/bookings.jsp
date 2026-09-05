<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib
        prefix="c"
        uri="jakarta.tags.core"
%>

<!DOCTYPE html>

<html>

<head>

    <title>Bookings</title>

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

    <h1>
        All Bookings
    </h1>

    <c:forEach var="b" items="${bookings}">

        <div class="card">

            <h2>
                Booking #${b.id}
            </h2>

            <p>
                    ${b.customerName}
                |
                    ${b.movieTitle}
                |
                    ${b.theatre}
            </p>

            <p>
                Seats:
                    ${b.seats}
            </p>

            <p>
                Amount:
                ₹${b.totalAmount}
            </p>

            <p>
                Status:
                    ${b.status}
            </p>

        </div>

    </c:forEach>

</main>

</body>

</html>