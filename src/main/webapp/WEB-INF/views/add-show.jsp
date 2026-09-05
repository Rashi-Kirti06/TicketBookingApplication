<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib
        prefix="c"
        uri="jakarta.tags.core"
%>

<!DOCTYPE html>

<html>

<head>

    <title>Add Show</title>

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

</nav>

<main class="container">

    <h1>Add Show</h1>

    <form
            method="post"
            action="/shows/add"
    >

        <label>
            Movie
        </label>

        <select
                name="movieId"
                required
        >

            <c:forEach
                    var="movie"
                    items="${movies}"
            >

                <option
                        value="${movie.id}"
                >

                        ${movie.title}

                </option>

            </c:forEach>

        </select>

        <input
                name="theatre"
                placeholder="Theatre"
                required
        >

        <input
                name="showTime"
                type="datetime-local"
                required
        >

        <button type="submit">
            Save Show
        </button>

    </form>

</main>

</body>

</html>