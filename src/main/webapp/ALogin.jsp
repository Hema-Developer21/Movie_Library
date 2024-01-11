<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="adminlogin" method="post">
Admin Email:<input type="text" name="AdminEmail"><br><br>
Admin Password:<input type="text" name="AdminPassword"><br><br>
<input type="submit">

</form>

<%String message=(String)request.getAttribute("Message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>

</body>
</html>