<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="flight.bizlogic.*, java.util.ArrayList, javax.servlet.http.HttpSession"%>
<%@ include file="WEB-INF/LoginHelper.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title></title>
</head>


<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="sidebar.jsp" />
	</div>

		
	<div class='main'>	
		
		<br><br>
		<p class="PageTitle">Shopping Cart</p>
		<p class="subheading"><b><c:out value="${fn:length(ShoppingCart)}"/></b> Items in Cart</p>
		
		<div class='ErrorMessage'><c:out value="${sMessage}" escapeXml="false"/></div>
		<table>
			<TR>
				<th>Flight ID</th>
				<th>Date</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Number of Stops</th>
				<th>Cost</th>
				<th>Number of Seats</th>
			</TR>
			
		
			<c:forEach items="${ShoppingCart}" var="flight" begin="0" end ="${fn:length(ShoppingCart)}" step="1" 
				varStatus="status">
				<tr class='${ status.count % 2 == 0 ? "repeatalt" : "repeat" }'>
					<TD><c:out value="${flight.nID}"/></TD>
					<TD><c:out value="${flight.sDateOfTravel}"/></TD>
					<TD><c:out value="${flight.sDepartureTime}"/></TD>
					<TD><c:out value="${flight.sArrivalTime}"/></TD>
					<TD><c:out value="${flight.nNumberOfStops}"/></TD>
					<TD><c:out value="${flight.dCost}"/></TD>
					
					<td> 
					<select name="${status.index}" id="Select">
						<c:forEach begin="1" end ="${flight.nSeats}" step="1" varStatus="status">
							<c:choose>
								<c:when test="${status.count==flight.nNumSelectedSeats}">
									<option value="${status.count}" selected="selected">${status.count}</option>
								</c:when>
								<c:otherwise>
									<option value="${status.count}">${status.count}</option>
								</c:otherwise>						
							</c:choose>
						</c:forEach>
					</select>
					</td>			
				</tr>
			</c:forEach>
			<tr><td>${flight.nNumSelectedSeats}</td></tr>
		</table>
		<br><br>
		<form action="<c:url value='ViewAndBook'/>" method=post>
		<input type="hidden" value="true" name="submit" />
		<input type="submit" value="Checkout" style="font-weight:bold;"></input>
		</form>
	</div>	
</body>
<script>
	//function SelectedChanged(SelectTag){
		//alert(SelectTag);
	//}
	
	
	$('Select').change(function () {
	     var optionSelected = $(this).find("option:selected");
	     var valueSelected  = optionSelected.val();
	     var textSelected   = optionSelected.text();
	     var name = $(this).attr('name');
	     var dataString = "UpdateCart=" + name + "&Value=" + textSelected; 
	     $.ajax({
				type: "POST",  
				url: "<c:url value='ShoppingCart'/>",
				data: dataString,
				})
	     
	     
	 });
	
</script>

</html>