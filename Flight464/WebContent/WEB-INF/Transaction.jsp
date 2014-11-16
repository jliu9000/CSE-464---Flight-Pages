<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="flight.bizlogic.*"%>
<%@ include file="LoginHelper.jsp" %>
<%@ include file="ErrorMessageHelper.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>Transaction</title>
</head>

<% 

	
%>


<jsp:useBean id="SelectedFlight" class="flight.bizlogic.FlightRecord" scope="request" /> 


<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>

	
	<div class='main'>
		<p class='PageTitle'>Transactions</p>
		<p class='subheading'>Flight Information:</p>
		
		<div class='ErrorMessage'><%=sMessage %></div>
		
		
		<table>
			<tr>
				<td class='key'>Flight Number: </td><td><jsp:getProperty name="SelectedFlight" property="nID" /></td>
				<td class='key'>Flight Date: </td><td><jsp:getProperty name="SelectedFlight" property="sDateOfTravel" /></td>
			</tr>
			<tr>
				<td class='key'>Departure Time:</td><td><jsp:getProperty name="SelectedFlight" property="sDepartureTime" /></td>
				<td class='key'>Arrival Time:</td><td><jsp:getProperty name="SelectedFlight" property="sArrivalTime" /></td>
			</tr>
			<tr>
				<td class='key'>Number of Stops:</td><td><jsp:getProperty name="SelectedFlight" property="nNumberOfStops" /></td>
				<td></td><td></td>
			</tr>
		</table>
		<br>
		<p><b>Cost:</b> $ <jsp:getProperty name="SelectedFlight" property="dCost" /></p>
		
		<p class='subheading'>Payment Information:</p>
		
		<form action='TransactionConfirmation' method=post>
		<input type="hidden" name="nFlightId" value='<jsp:getProperty name="SelectedFlight" property="nID" />'/>
		<input type="hidden" name="nSeats" value='<jsp:getProperty name="SelectedFlight" property="nQueuedSeats" />' />
		<input type="hidden" name="sClass" value='<jsp:getProperty name="SelectedFlight" property="sClass" />' />
		<input type="hidden" name="dCost" value='<jsp:getProperty name="SelectedFlight" property="dCost" />'/>
		
		
			<table>
				<tr>
					<td class='key'>Account Holder's Name: </td><td><input type="text" name="sAccountHolder" /></td>
				</tr>
				<tr>
					<td class='key'>Routing Number: </td><td><input type="text" name="nRoutingNumber" /></td>
				</tr>
				<tr>
					<td class='key'>Account Number: </td><td><input type="password" name="nAccountNumber" /></td>
				</tr>
				<tr>
					<td></td><td></td>
				</tr>
				<tr>
					<td class='button' colspan=2>	
						<input type="submit" value="Confirm"></input>
				        &nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="Cancel()">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
		
	</div>

<br><br><br>



</body>

<script>
	
	function Cancel() {
		window.location.replace("FlightSearch.jsp");
	}
</script>




</html>