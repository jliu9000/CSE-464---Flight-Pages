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
		<p class='PageTitle'>Transactions</p>
		<p class='subheading'>Flight Information:</p>
		<table>
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
				<td></td><td></td>
			</tr>
		</table>
		<br>
		<p><b>Cost:</b> $<%=r.getCost() %></p>
		
		<p class='subheading'>Payment Information:</p>
		
		
		<table>
			<form action='TransactionConfirmation.jsp' method=post>
				<tr>
					<td class='key'>Account Holder's Name: </td><td><input type="text" name="sAccountHolder"></td>
				</tr>
				<tr>
					<td class='key'>Routing Number: </td><td><input type="text" name="nRoutingNumber"></td>
				</tr>
				<tr>
					<td class='key'>Account Number: </td><td><input type="text" name="nAccountNumber"></td>
				</tr>
				<tr>
					<td></td><td></td>
				</tr>
				<tr>
					<td colspan=2 class='button'>	
						<input type="submit" value="Confirm"></input>
						</form>
					</td>
					
				</tr>
				<tr>
					<td colspan=2 class='button'>						
						<a href="FlightSearch.jsp"><button>Cancel</button></a>
					</td>
				
				</tr>
		</table>
			
		
	</div>





</body>





</html>