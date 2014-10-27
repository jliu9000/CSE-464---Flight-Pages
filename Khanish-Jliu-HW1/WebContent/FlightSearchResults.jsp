<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<title>Flight Search Results</title>

<%@ page import="flight.bizlogic.RecordFactory"%>
</head>
<body>
	<div id='sidebar' class='sidebar'>
	    <script>
            $("#sidebar").load("sidebar.html");
        </script>
	</div>
	
	<%  //get the records
		RecordFactory records = new RecordFactory(0);
	  	records.generateRecords();
	%>
	
	<div class="main">	
		
		<br><br>
		<p class="PageTitle">Flight Search Results</p>
		<p class="subheading"><b><%=records.TotalRecords() %></b> Results Found</p>
		
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
			
		
			<%for (int i = 0; i<records.TotalRecords(); i++){%>
			<tr class='<%= i % 2 == 1 ? "repeatalt" : "repeat" %>'>
			<%=records.toHTMLTableRow(i) %>
				<td class="button">
					<a href="ViewAndBook.jsp"><button>View and Book</button></a>
				</td>
			</tr>
			<%} %>
			
		</table>
		<br><br>
	</div>	

</body>






</html>