<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="LoginHelper.jsp" %>
<%@ include file="ErrorMessageHelper.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<%@ page import="flight.bizlogic.FlightRecord"%>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<title>Transaction Confirmation</title>
</head>
<body>

	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>
		
			
	<jsp:useBean id="ConfirmedFlight" class="flight.bizlogic.FlightRecord" scope="session" /> 

	<div class='main'>
		
		<p class='PageTitle'>Transaction Confirmation</p>
		<br>
		<div class='ErrorMessage'><%=sMessage %></div>
		<br>
		<p class='subheading'>Flight Information:</p>
		<table>
			<tr>
				<td class='key'>Account Holder:</td><td><%=request.getParameter("sAccountHolder")%></td>
			</tr>
			<tr>
				<td class='key'>Flight Number: </td><td><jsp:getProperty name="ConfirmedFlight" property="nID" /></td>
				<td class='key'>Flight Date: </td><td><jsp:getProperty name="ConfirmedFlight" property="sDateOfTravel" /></td>
			</tr>
			<tr>
				<td class='key'>Departure Time:</td><td><jsp:getProperty name="ConfirmedFlight" property="sDepartureTime" /></td>
				<td class='key'>Arrival Time:</td><td><jsp:getProperty name="ConfirmedFlight" property="sArrivalTime" /></td>
			</tr>
			<tr>
				<td class='key'>Number of Stops:</td><td><jsp:getProperty name="ConfirmedFlight" property="nNumberOfStops" /></td>
				<td></td><td></td>
			</tr>
		</table>
		<br>
		<p><b>Cost:</b> $<jsp:getProperty name="ConfirmedFlight" property="dCost" /></p>
		<br>
		
		<a href="FlightSearch.jsp"><button>Home</button></a>
		
		
		
	</div>
</body>
</html>