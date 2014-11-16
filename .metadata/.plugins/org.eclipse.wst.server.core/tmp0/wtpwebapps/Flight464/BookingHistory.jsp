<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<%@ page import="flight.bizlogic.FlightRecord,java.util.ArrayList"%>


<title>Booking History</title>
</head>
<body>
	<div id='sidebar' class='sidebar'>
	    <script>
            $("#sidebar").load("sidebar.jsp");
        </script>
	</div>

		<% 
			ArrayList<FlightRecord> alBookings = (ArrayList<FlightRecord>) request.getSession().getAttribute("alBooking");
		
		   //can add list of user's transactions here later on.
		 %>
		 
	<div class='main'>
		
		<p class="PageTitle">Booking History</p>
		<p class="subheading"><%=alBookings.size() %> Total Records</p>
		
		<table>
			<TR>
				<th>Ticket Number: </th> <th> Flight Date </th>
			</TR> 
			<% 
			int i = 1;
			for(FlightRecord r : alBookings) {
			i++;
			%>
			<tr class='<%= i % 2 == 1 ? "repeatalt" : "repeat" %>'>
				<TD class='key'><%=r.getnID() %></TD>
				<TD><%=r.getsDateOfTravel() %></TD>
			</TR>
			<% } %>
		</table>
	
	</div>
	
<BR><BR><BR><BR>


</table>
</body>
</html>