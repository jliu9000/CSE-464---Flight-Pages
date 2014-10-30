<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<%@ page import="flight.bizlogic.RecordFactory,flight.bizlogic.FlightRecord"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<title>Transaction Confirmation</title>
</head>
<body>

	<div id='sidebar' class='sidebar'>
	    <script>
            $("#sidebar").load("sidebar.jsp");
        </script>
	</div>
		
		<%
			RecordFactory records = new RecordFactory(1);
			FlightRecord r = records.TestRecord();
		%>	

	<div class='main'>
		
		<p class='PageTitle'>Transaction Confirmation</p>
		<br>
		<p class='message'>Your transaction has been confirmed.</p>
		<br>
		<p class='subheading'>Flight Information:</p>
		<table>
			<tr>
				<td class='key'>Account Holder:</td><td><%=request.getParameter("sAccountHolder")%></td>
			</tr>
			<tr>
				<td class='key'>Flight Number: </td><td><%=r.getID() %></td>
				<td class='key'>Flight Date: </td><td><%=r.getDateOfTravel() %></td>
			</tr>
			<tr>
				<td class='key'>Departure Time:</td><td><%=r.getDepartureTime() %></td>
				<td class='key'>Arrival Time:</td><td><%=r.getArrivalTime() %></td>
			</tr>
			<tr>
				<td class='key'>Number of Stops:</td><td><%=r.getNumberOfStops() %></td>
			</tr>
			
		</table>
		<br>
		<p><b>Cost:</b> $<%=r.getCost() %></p>
		<br>
		
		<a href="FlightSearch.jsp"><button>Home</button></a>
		
		
		
	</div>
</body>
</html>