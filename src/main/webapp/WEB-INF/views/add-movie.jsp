<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <title>Add Movie</title>

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

    <h1>Add Movie</h1>

    <form
            method="post"
            action="/movies/add"
    >

        <input
                name="title"
                placeholder="Title"
                required
        >

        <input
                name="genre"
                placeholder="Genre"
                required
        >

        <input
                name="language"
                placeholder="Language"
                required
        >

        <input
                name="durationMinutes"
                type="number"
                placeholder="Duration"
                required
        >

        <button type="submit">
            Save Movie
        </button>

    </form>

</main>

</body>

</html>