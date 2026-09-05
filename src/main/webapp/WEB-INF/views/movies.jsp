<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib
        prefix="c"
        uri="jakarta.tags.core"
%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>

<html>

<head>

    <title>Movies</title>

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

    <h1>Movies</h1>

    <a
            class="button"
            href="/movies/add"
    >
        Add Movie
    </a>

    <div class="grid">

        <c:forEach
                var="movie"
                items="${movies}"
        >

            <div class="card">

                <h2>
                        ${movie.title}
                </h2>

                <p>
                    Genre: ${movie.genre}
                </p>

                <p>
                    Language: ${movie.language}
                </p>

                <p>
                    Duration: ${movie.durationMinutes} minutes
                </p>

            </div>

        </c:forEach>

    </div>

</main>

</body>

</html>