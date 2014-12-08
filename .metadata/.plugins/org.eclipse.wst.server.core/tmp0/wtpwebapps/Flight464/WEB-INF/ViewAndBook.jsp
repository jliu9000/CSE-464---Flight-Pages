<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="LoginHelper.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<%@ page import="flight.bizlogic.*"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<title>View and Book</title>


</head>

		
		<jsp:useBean id="SelectedFlight" class="flight.bizlogic.FlightRecord" scope="request" /> 
		
		
<body>

	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>


	
<div class='main'>

	<p class="PageTitle">View and Book</p>
	<div class='ErrorMessage'><c:out value="${sMessage}" escapeXml="false"/></div>
	
	<form action='ViewAndBook' method=post>
	
		<table>
				<tr><td class="key">Number of Seats</td><td>
					<select id="SelectedSeats" name="nSeats">
						<c:forEach begin="1" end ="${SelectedFlight.nSeats}" step="1" varStatus="status">

							<option value="${status.count}">${status.count}</option>
							
						</c:forEach>
					
						
					</select>
					</td>
				</td></tr>
				<tr><td class="key">Flight ID: </td><td><c:out value="${SelectedFlight.nID}"/></td></tr>
				<tr><td class='key'>Flight Date: </td><td><c:out value="${SelectedFlight.sDateOfTravel}"/></td></tr>
				<tr><td class='key'>Departure Time: </td><td><c:out value="${SelectedFlight.sDepartureTime}"/></td></tr>
				<tr><td class='key'>Departure Location: </td><td><c:out value="${SelectedFlight.sSource}" /></td></tr>
				<tr><td class='key'>Arrival Time: </td><td><c:out value="${SelectedFlight.sArrivalTime}" /></td></tr>
				<tr><td class='key'>Arrival Location: </td><td><c:out value="${SelectedFlight.sDestination}" /></td></tr>
				<tr><td class='key'>Number of Stops: </td><td><c:out value="${SelectedFlight.nNumberOfStops}" /></td></tr>
				<tr><td class='key'>Class: </td><td><c:out value="${SelectedFlight.sClass}" /></td></tr>
				<tr><td class='key'>Cost: </td><td>$<c:out value="${SelectedFlight.dCost}" /></td></tr>
				
	 
		</table>	
	
		<br><br>
		<table>
		<tr><td><a href="<c:url value='FlightSearchResults.jsp'/>"><button type="button" onclick="goBack()">Back</button></a></td>
		<td>	
				<input type="hidden" name="dCost" value='<c:out value="${SelectedFlight.dCost}" />'>
				<input type="hidden" name="nSeats" value='<c:out value="${SelectedFlight.nSeats}" />'>
				<input type="hidden" name="sClass" value='<c:out value="${SelectedFlight.sClass}" />'>			
				<input type="hidden" name="nFlightId" value='<c:out value="${SelectedFlight.nID}" />'>
				<button type="button" id="addToCart" onclick="addToShoppingCart()" style="font-weight:bold;">Add to Cart</button>
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
		
		window.location.replace("<c:url value='FlightSearch.jsp'/>");
	}
	
	function addToShoppingCart(){
		
		var sNumSeats = "sSelectedNumSeats=" + $( "#SelectedSeats option:selected" ).text();
		$("#addToCart").prop("disabled",true);

		$.ajax({
			type: "POST",  
			url: "<c:url value='ShoppingCart'/>",
			data: sNumSeats,
			success: function(){
				alert("Successfully added flight to your cart!");
			}
			})
		
	}
	


</script>
</html>