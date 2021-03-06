<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">
<title>Flight Search</title>
</head>


<body>
	<div id='sidebar' class='sidebar'>
        <script>
            $('#sidebar').load('sidebar.jsp');
        </script>
	</div>
	
	<div class='main'>
		<p class="PageTitle">Flight Search</p>
	
		<form name="SearchFlights" action='FlightSearchResults.jsp' method=get>
			<table width=600>
				<tr>
					<TD>Flight Source:</td><td> <input type="text" name="sSource"></TD>
					<td>Flight Destination:</td><td>  <input type="text" name="sDestination"></td>
				</tr>
				<tr>
					<td>Date of Travel: </td><td> <input type="text" name="sDate"></td>
					<td>Number of Seats: </td><td> <input type="text" name="nSeats"></td>
				</tr>
				<tr>
					<td>Class:</td>
					<td> 
						<select name="sClass">
						<option value="first">First Class</option>
						<option value="business">Business</option>
						<option value="economy">Economy</option>
						</select>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Search">
		
		</form>

	</div>


</body>
</html>