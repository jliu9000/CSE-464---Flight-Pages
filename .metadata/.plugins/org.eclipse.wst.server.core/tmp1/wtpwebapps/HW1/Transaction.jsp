<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="flight.bizlogic.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<title>Transaction</title>
</head>

<body>

<a id="login" href="login.jsp">
<%=session.getAttribute("nUserID") != null ? "Logout" : "Login"%>
</a>

<%
	RecordFactory records = new RecordFactory(1);
	FlightRecord r = records.TestRecord();
%>

<p class='PageTitle'>Transactions</p>
<p class='subheading'>Flight Information:</p>
<table>
	<tr>
		<td>Flight Number: </td><td><%=r.getID() %></td>
		<td>Flight Date: </td><td><%=r.getDateOfTravel() %></td>
	</tr>
	<tr>
		<td>Departure Time:</td><td><%=r.getDepartureTime() %></td>
		<td>Arrival Time:</td><td><%=r.getArrivalTime() %></td>
	</tr>
	<tr>
		<td>Number of Stops:</td><td><%=r.getNumberOfStops() %></td>
		<td></td><td></td>
	</tr>
</table>
<br>
<p>Cost: <%=r.getCost() %></p>

<p class='subheading'>Payment Information:</p>


<div>
	<form action='TransactionConfirmation.jsp' method=post>
		Account Holder's Name: <input type="text" name="sAcctName">
		<br>
		Routing Number: <input type="text" name="nRoutingNumber">
		<br>
		Account Number: <input type="text" name="nAccountNumber">
		<br>
		<input type="submit" value="Confirm"></input>
	</form>
	<a href="FlightSearch.jsp"><button>Cancel</button></a>
	
</div>






</body>





</html>