<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
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


		 
	<div class='main'>
		
		<p class="PageTitle">Booking History</p>
		<p class="subheading"><c:out value="${fn:length(alBooking)}"/> Total Records</p>
		
		<table>
			<TR>
				<th>Ticket Number: </th> <th> Flight Date </th>
			</TR> 
			<c:forEach items="${alBooking}" var="booking" begin="0" end ="${fn:length(alBooking)}" step="1" 
				varStatus="status">
				<tr class='${ status.count % 2 == 0 ? "repeatalt" : "repeat" }'>
					<TD class='key'><c:out value="${booking.nID}"/></TD>
					<TD><c:out value="${booking.sDateOfTravel}"/></TD>
				</tr>
			</c:forEach>
		</table>
	
	</div>
	
<BR><BR><BR><BR>


</table>
</body>
</html>