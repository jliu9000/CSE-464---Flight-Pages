<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<%@ page import="flight.bizlogic.*"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<title>View and Book</title>


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
<jsp:useBean id="SelectedFlight" class="flight.bizlogic.FlightRecord" scope="session" /> 
	
<div class='main'>

	<p class="PageTitle">View and Book</p>
	
	
		<table>
			<form action='Transaction.jsp' method=get>
				<tr><td class="key">Number of Seats</td><td>
					<select name="nSeats">
						<% for (int i=1; i<=r.getSeats(); i++) {%> 
							<option value="<%=i %>"><%=i %></option>
						<%} %>
					</select>
					</td>
				</td></tr>
				<tr><td class="key">Flight ID: </td><td><jsp:getProperty name="SelectedFlight" property="nID" /></td></tr>
				<tr><td class='key'>Flight Date: </td><td><jsp:getProperty name="SelectedFlight" property="sDateOfTravel" /></td></tr>
				<tr><td class='key'>Departure Time: </td><td><jsp:getProperty name="SelectedFlight" property="sDepartureTime" /></td></tr>
				<tr><td class='key'>Departure Location: </td><td><jsp:getProperty name="SelectedFlight" property="sSource" /></td></tr>
				<tr><td class='key'>Arrival Time: </td><td><jsp:getProperty name="SelectedFlight" property="sArrivalTime" /></td></tr>
				<tr><td class='key'>Arrival Location: </td><td><jsp:getProperty name="SelectedFlight" property="sDestination" /></td></tr>
				<tr><td class='key'>Number of Stops: </td><td><jsp:getProperty name="SelectedFlight" property="nNumberOfStops" /></td></tr>
				<tr><td class='key'>Class: </td><td><jsp:getProperty name="SelectedFlight" property="sClass" /></td></tr>
				<tr><td class='key'>Cost: </td><td>$<jsp:getProperty name="SelectedFlight" property="dCost" /></td></tr>
				
	
		</table>	
	
	<br><br>
	<table>
	<tr><td><a href="FlightSearchResults.jsp"><button type="button" onclick="goBack()">Back</button></a></td>
	<td><input type="submit" value="Submit" style="font-weight:bold;"></input></td>
	<td><button type=button onclick="goHome()">Home</button></td></tr>
	</table>		</form>

</div>
</body>

<script>
	function goBack() {

		window.location.replace("FlightSearchResults.jsp");
	}
	
	function goHome() {
		
		window.location.replace("FlightSearch.jsp");
	}



</script>
</html>