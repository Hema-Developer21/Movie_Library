<%@page import="dao.Dao1"%>
<%@page import="java.util.List"%>
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

<h1>WELCOME</h1>

<% Dao1 dao = new Dao1();%>

<% List<Movie> movies = dao.getAllMovies(); %>

<table  border="2px" class="table">
<tr>
<th>Id</th>
<th>Name</th>
<th>Price</th>
<th>Rating</th>
<th>Genre</th>
<th>Language</th>
<th>Image</th>
</tr>
<%for(Movie m:movies){ %>
<tr>
<td><%=m.getMovieId() %></td>
<td><%=m.getMovieName() %></td>
<td><%=m.getMoviePrice() %></td>
<td><%=m.getMovieRating() %></td>
<td><%=m.getMovieGenre() %></td>
<td><%=m.getMovieLanguage() %></td>
<% String base64image= new String(Base64.getEncoder().encode(m.getMovieImage())); %>
	<td><img  src="data:image/jpg;base64, <%=base64image %>" height="100px" width="100px" > </td>
	<td><a href="deletemovie?id=<%=m.getMovieId() %>">delete</a></td>
	<td><a href="editmovie?id=<%=m.getMovieId() %>">Edit</a></td>
	
</tr>
<% } %>


</table>


<a href="Addmovie.jsp">ADDMOVIE</a>


</body>
</html>