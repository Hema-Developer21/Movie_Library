<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Movie m=(Movie)request.getAttribute("Movie"); %>
<form action="updatemovie" method="post" enctype="multipart/form-data">
Movie ID:<input type="text" name="MovieId" value="<%=m.getMovieId() %>" readonly><br><br>
Movie Name:<input type="text" name="MovieName" value="<%=m.getMovieName() %>"><br><br>
Movie Price:<input type="text" name="MoviePrice" value="<%=m.getMoviePrice() %>"><br><br>
Movie Rating:<input type="text" name="MovieRating" value="<%=m.getMovieRating() %>"><br><br>
Movie Genre:<input type="text" name="MovieGenre" value="<%=m.getMovieGenre() %>"><br><br>
Movie Language:<input type="text" name="MovieLanguage" value="<%=m.getMovieLanguage() %>"><br><br>
Movie Image:<input type="file" name="MovieImage"><br><br>
<input type="submit">
<% String base64image= new String(Base64.getEncoder().encode(m.getMovieImage())); %>
	<img  src="data:image/jpg;base64, <%=base64image %>" height="100px" width="100px" > 

</form>


</body>
</html>