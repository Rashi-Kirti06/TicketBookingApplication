<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib
        prefix="c"
        uri="jakarta.tags.core"
%>

<!DOCTYPE html>

<html>

<head>

    <title>Shows</title>

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

    <h1>Shows</h1>

    <a
            class="button"
            href="/shows/add"
    >
        Add Show
    </a>

    <div class="grid">

        <c:forEach
                var="show"
                items="${shows}"
        >

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

                <a
                        class="button"
                        href="/book/${show.id}"
                >
                    Book Now
                </a>

            </div>

        </c:forEach>

    </div>

</main>

</body>

</html>