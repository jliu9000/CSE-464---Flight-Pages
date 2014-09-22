<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<%@ page import="flight.bizlogic.*"%>


<title>View and Book</title>


</head>
<body>

<div class='sidebar'>
	<a id="login" href="login.jsp">
	<%=session.getAttribute("nUserID") != null ? "Logout" : "Login"%>
	</a>
</div>

	<%  
		RecordFactory records = new RecordFactory(1);
		FlightRecord r = records.TestRecord();
	%>
	
<div class='main'>

	<p class="PageTitle">View and Book</p>
	
	
		<table>
			<tr><td class="key">Flight ID: </td><td><%=r.getID() %></td></tr>
			<tr><td class='key'>Flight Date: </td><td><%=r.getDateOfTravel() %></td></tr>
			<tr><td class='key'>Departure Time: </td><td><%=r.getDepartureTime() %></td></tr>
			<tr><td class='key'>Departure Location: </td><td><%=r.getSource() %></td></tr>
			<tr><td class='key'>Arrival Time: </td><td><%=r.getArrivalTime() %></td></tr>
			<tr><td class='key'>Arrival Location: </td><td><%=r.getDestination() %></td></tr>
			<tr><td class='key'>Number of Stops: </td><td><%=r.getNumberOfStops() %></td></tr>
			<tr><td class='key'>Class: </td><td><%=r.getFlightClass() %></td></tr>
			<tr><td class='key'>Cost: </td><td>$<%=r.getCost() %></td></tr>
		</table>	
	
	<br><br>
	
	<a href="FlightSearchResults.jsp"><button>Back</button></a>
	<a href="Transaction.jsp"><button><b>Select</b></button></a>
	<a href="FlightSearch.jsp"><button>Home</button></a>
	

</div>
</body>
</html>