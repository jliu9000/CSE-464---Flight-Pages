<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="WEB-INF/LoginHelper.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">



<title>Flight Search</title>
</head>


<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="sidebar.jsp" />
	</div>
	
	<div class='main'>
		<p class="PageTitle">Flight Search</p>
		<div class='ErrorMessage'><c:out value="${sMessage}" escapeXml="false"/></div>
		<form action='<c:url value='FlightSearchQuery'/>' method=post>
			<table width=600>
				<tr>
					<TD>Flight Source:</td><td> <input type="text" name="sSource" value=""></TD>
					<td>Flight Destination:</td><td>  <input type="text" name="sDestination" value=""></td>
				</tr>
				<tr>
					<td>Date of travel (MM/DD/YYYY): </td><td> <input type="text" name="sDateStart" value=""></td>
					<td>Number of Seats: </td><td> <input type="text" name="nSeats" value=""></td>
				</tr>
				<tr>
					<td>Class:</td>
					<td> 
						<select name="sClass">
							<option value="first">First Class</option>
							<option value="business">Business</option>
							<option value="economy">Economy</option>
						</select>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Search">
		
		</form>

	</div>


</body>
</html>