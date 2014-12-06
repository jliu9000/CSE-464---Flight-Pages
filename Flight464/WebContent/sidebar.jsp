<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/FlightStyles.css">



</head>





<jsp:useBean id="Clients" class="flight.bizlogic.Clients" scope="session" /> 

<body>


		
		<ul class="sidebar">
			<li>
				<form action="Logout" method=post>
					<input type='hidden' name='Logout' value='true'>
					<input type='submit' value='Logout'>
				</form>

			</li>
			<li> </li>
			<li> </li>
			<li>Welcome, <c:out value="${sessionScope.Clients.oUser.sFullName}"/>!</li>
			<li> </li>
			<li>Orginization: <c:out value="${sessionScope.Clients.oOrg.sName}"/>!</li>
			<li> </li>
			<li> </li>
			<li><a href="./FlightSearch.jsp">Home</a></li>
			<li><a href="./ShoppingCart.jsp">Shopping Cart / Check Out</a></li>
			<li>
				<form action="BookingHistory" method=post>	
					<input type='hidden' name='BookingHistory' value='true'>
					<input type='submit' value='Booking History'>
				</form>
			</li>
			<li></li>
		</ul>

	
</body>
</html>