<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="LoginHelper.jsp" %>
<%@ include file="ErrorMessageHelper.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<%@ page import="flight.bizlogic.*"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<title>View and Book</title>


</head>

		<% //check if a flight record has been set
			Integer nAvailableSeats = null;

			if (request.getAttribute("nAvailableSeats") == null) {
				//response.sendRedirect("FlightSearch.jsp");
				nAvailableSeats = 0;
			} else {
				nAvailableSeats = (Integer) request.getAttribute("nAvailableSeats");
			}
 		%>
		
		<jsp:useBean id="SelectedFlight" class="flight.bizlogic.FlightRecord" scope="request" /> 
		
		
<body>

	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>


	
<div class='main'>

	<p class="PageTitle">View and Book</p>
	<div class='ErrorMessage'><%=sMessage %></div>
	
	<form action='ViewAndBook' method=post>
	
		<table>
				<tr><td class="key">Number of Seats</td><td>
					<select id="SelectedSeats" name="nSeats">
						<% for (int i=1; i<=nAvailableSeats; i++) {%> 
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
		<td>	
				<input type="hidden" name="dCost" value='<jsp:getProperty name="SelectedFlight" property="dCost" />'>
				<input type="hidden" name="nSeats" value='<jsp:getProperty name="SelectedFlight" property="nSeats" />'>
				<input type="hidden" name="sClass" value='<jsp:getProperty name="SelectedFlight" property="sClass" />'>			
				<input type="hidden" name="nFlightId" value='<jsp:getProperty name="SelectedFlight" property="nID" />'>
				<button type="button" onclick="addToShoppingCart()" style="font-weight:bold;">Add to Cart</button>
		</td>
		<td><button type=button onclick="goHome()">Home</button></td></tr>
		</table>		
	</form>

</div>
</body>

<script>
	function goBack() {

		history.go(-1);
	}
	
	function goHome() {
		
		window.location.replace("FlightSearch.jsp");
	}
	
	function addToShoppingCart(){
		
		var sNumSeats = "sSelectedNumSeats=" + $( "#SelectedSeats option:selected" ).text();
		$.ajax({
			type: "POST",  
			url: "ShoppingCart",
			data: sNumSeats,
			success: function(){
				alert("succesfully added flight to your cart!");
			}
			})
		
	}
	


</script>
</html>