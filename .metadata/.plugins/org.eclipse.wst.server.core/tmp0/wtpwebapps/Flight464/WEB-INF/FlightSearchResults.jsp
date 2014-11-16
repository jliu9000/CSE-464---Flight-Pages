<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="flight.bizlogic.*, java.util.ArrayList"%>
<%@ include file="LoginHelper.jsp" %>
<%@ include file="ErrorMessageHelper.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<title>Flight Search Results</title>

</head>
	<%  
		int nTotalRecords = 0;
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) request.getAttribute("lSearchResults");
		if (alRecords == null){
			sMessage = "Unable to load records, please try again";
		} else {
			nTotalRecords = alRecords.size();
		}
	  	
	%>

<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>

		
	<div class='main'>	
		
		<br><br>
		<p class="PageTitle">Flight Search Results</p>
		<p class="subheading"><b><%=nTotalRecords %></b> Results Found</p>
		
		<div class='ErrorMessage'><%=sMessage %></div>
		
		<table>
			<TR>
				<th>Flight ID</th>
				<th>Date</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Number of Stops</th>
				<th>Cost</th>
				<th>Additional Details</th>
			</TR>
			
		
			<%
				FlightRecord frTemp;			
				for (int i = 0; i<nTotalRecords; i++){%>
				<tr class='<%= i % 2 == 1 ? "repeatalt" : "repeat" %>'>
					<% frTemp = alRecords.get(i);  %>
					<TD><%= frTemp.getnID() %></TD>
					<TD><%= frTemp.getsDateOfTravel() %></TD>
					<TD><%= frTemp.getsDepartureTime() %></TD>
					<TD><%= frTemp.getsArrivalTime() %></TD>
					<TD><%= frTemp.getnNumberOfStops() %></TD>
					<TD><%= frTemp.getdCost() %></TD>
					<TD class='button'>	
						<form action="FlightSearchResults" method=post>
							<input type='hidden' name='nFlightId' value='<%= frTemp.getnID() %>'>
							<input type='hidden' name='dCost' value='<%= frTemp.getdCost() %>' />
							<input type='hidden' name='sClass' value='<%= frTemp.getsClass() %>' />
							<input type='submit' value='View and Book'>
						</form>
					</td>			
				</tr>
			<%} %>
			
		</table>
		<br><br>
	
	</div>	
</body>






</html>