<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">



</head>

<jsp:useBean id="User" class="flight.bizlogic.User" scope="session" /> 

<body>


		
		<ul class="sidebar">
			<li><a href="Login.jsp">Login</a></li>
			<li> </li>
			<li> </li>
			<li>Welcome, <jsp:getProperty name="User" property="username" />!</li>
			<li> </li>
			<li><a href="FlightSearch.jsp">Home</a></li>
			<li><a href="BookingHistory.jsp">Booking History</a></li>
			<li></li>
		</ul>

	
</body>
</html>