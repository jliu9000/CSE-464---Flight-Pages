<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="flight.bizlogic.*"%>
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
<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>
	
	<%  
		if (request.getAttribute("Count") == null || request.getAttribute("SearchResults") == null){
			response.sendRedirect("FlightSearch.jsp");
		}
	  	
		Integer nTotalRecords;
	  	nTotalRecords = (Integer) request.getAttribute("Count");
	  	
	%>
	
	<jsp:useBean id="SearchResults" class="flight.bizlogic.FlightRecordList" scope="request" /> 
	
	
	<div class="main">	
		
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
			
		
			<%for (int i = 0; i<nTotalRecords; i++){%>
			<tr class='<%= i % 2 == 1 ? "repeatalt" : "repeat" %>'>
				<TD> <jsp:getProperty name="SearchResults" property="flightId" /> </TD>
				<TD> <jsp:getProperty name="SearchResults" property="date" /> </TD>
				<TD> <jsp:getProperty name="SearchResults" property="departureTime" /> </TD>
				<TD> <jsp:getProperty name="SearchResults" property="arrivalTime" /> </TD>
				<TD> <jsp:getProperty name="SearchResults" property="numberOfStops" /> </TD>
				<TD> <jsp:getProperty name="SearchResults" property="cost" /> </TD>
				<TD class='button'>	
					<form action="FlightSearchResults" method=post>
						<input type='hidden' id='dCost' value='<jsp:getProperty name="SearchResults" property="cost" />' />
						<input type='hidden' id='sClass' value='<jsp:getProperty name="SearchResults" property="sClass" />' />
						<input type='hidden' id='nFlightId' value='<jsp:getProperty name="SearchResults" property="idAndIncrement" />'>
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