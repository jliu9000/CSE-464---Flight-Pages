<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<%@ page import="flight.bizlogic.RecordFactory, flight.bizlogic.FlightRecord,java.util.ArrayList"%>


<title>Booking History</title>
</head>
<body>
	<div class='sidebar'>
		<a id="login" href="Login.jsp">
		<%=session.getAttribute("nUserID") != null ? "Logout" : "Login"%>
		</a>
		<br>
		<br>
		<a href="FlightSearch.jsp"><button>Home</button></a>
	</div>

		<% RecordFactory rf = new RecordFactory(0);
			ArrayList<FlightRecord> oRecordsList;
			rf.generateRecords();
			
		 	oRecordsList = rf.getRecords();
		   //can add list of user's transactions here later on.
		 %>
		 
	<div class='main'>
		
		<p class="PageTitle">Booking History</p>
		<p class="subheading"><%=oRecordsList.size() %> Total Records</p>
		
		<table>
			<TR>
				<th>Ticket Number: </th> <th> Flight Date </th>
			</TR> 
			<% for(FlightRecord r : oRecordsList) {%>
			<TR>
				<TD class='key'><%=r.getID() %></TD>
				<TD><%=r.getDateOfTravel() %></TD>
			</TR>
			<% } %>
		</table>
	
	</div>



</table>
</body>
</html>