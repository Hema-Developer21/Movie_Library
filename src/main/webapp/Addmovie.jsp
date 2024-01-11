<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Add Movie</h2>

<form action="SaveMovie1" method="post" enctype="multipart/form-data">
Movie ID:<input type="text" name="MovieId"><br><br>
Movie Name:<input type="text" name="MovieName"><br><br>
Movie Price:<input type="text" name="MoviePrice"><br><br>
Movie Rating:<input type="text" name="MovieRating"><br><br>
Movie Genre:<input type="text" name="MovieGenre"><br><br>
Movie Language:<input type="text" name="MovieLanguage"><br><br>
Movie Image:<input type="file" name="MovieImage"><br><br>
<input type="submit">

</form>

</body>
</html>