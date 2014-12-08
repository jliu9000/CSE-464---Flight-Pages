<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="flight.bizlogic.*, java.util.ArrayList"%>
<%@ include file="LoginHelper.jsp" %>

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

		
	<div class='main'>	
		
		<br><br>
		<p class="PageTitle">Flight Search Results</p>
		<p class="subheading"><b><c:out value="${fn:length(lSearchResults)}"/></b> Results Found</p>
		
		<div class='ErrorMessage'><c:out value="${sMessage}" escapeXml="false"/></div>
		
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

			<c:forEach items="${lSearchResults}" var="flight" begin="0" end ="${fn:length(lSearchResults)}" step="1" 
				varStatus="status">
				<tr class='${ status.count % 2 == 0 ? "repeatalt" : "repeat" }'>
				<TD><c:out value="${flight.nID}"/></TD>
				<TD><c:out value="${flight.sDateOfTravel}"/></TD>
				<TD><c:out value="${flight.sDepartureTime}"/></TD>
				<TD><c:out value="${flight.sArrivalTime}"/></TD>
				<TD><c:out value="${flight.nNumberOfStops}"/></TD>
				<TD><c:out value="${flight.dCost}"/></TD>
					<TD class='button'>	
						<form action="<c:url value='FlightSearchResults'/>" method=post>
							<input type='hidden' name='nFlightId' value='<c:out value="${flight.nID}"/>'>
							<input type='hidden' name='dCost' value='<c:out value="${flight.dCost}"/>' />
							<input type='hidden' name='sClass' value='<c:out value="${flight.sClass}"/>' />
							<input type='submit' value='View and Book'>
						</form>
					</td>			
				
		
				</tr>
				
			
			</c:forEach>
		
		
			
		</table>
		<br><br>
	
	</div>	
</body>
</html>