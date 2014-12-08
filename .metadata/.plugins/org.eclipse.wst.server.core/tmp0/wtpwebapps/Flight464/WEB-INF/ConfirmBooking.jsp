<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="flight.bizlogic.*, java.util.ArrayList"%>
<%@ include file="LoginHelper.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Booking</title>
</head>


	
	
<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>

		
	<div class='main'>	
		
		<br><br>
		<p class="PageTitle">Confirm Booking</p>
		<p class="subheading"></p>
		
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
					<TD><c:out value="${flight.nNumSelectedSeats}"/></TD>
				</tr>
			</c:forEach>
			
		</table>

		<BR><BR>
		
			<table>
				<tr>
					<td class='key'>Account Holder's Name: </td><td><input type="text" id="sAccountHolder" /></td>
				</tr>
				<tr>
					<td class='key'>Routing Number: </td><td><input type="text" id="nRoutingNumber" /></td>
				</tr>
				<tr>
					<td class='key'>Account Number: </td><td><input type="password" id="nAccountNumber" /></td>
				</tr>
				<tr>
					<td class='key'>Pin: </td><td><input type="password" maxlength=4 id="nPin" /></td>
				</tr>
				<tr>
					<td class='key'>Total Cost: </td><td><c:out value="${dTotalCost}"/></td>
				</tr>
				<tr></tr>
				<tr>
					<td class='button' colspan=2>	
						<button type="button" onclick="ConfirmTransaction()">Confirm</button>
				        &nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="Cancel()">Cancel</button>
					</td>
				</tr>
			</table>
			<input id='dTotalCost' value='<c:out value="${dTotalCost}"/>' type=hidden></input>
		
		
	</div>

</body>
<script>
	function ConfirmTransaction(){
		
		var dTotalCost = $("#dTotalCost").val();
		var nAcctNumber = $("#nAccountNumber").val();
		var nRoutingNumber = $("#nRoutingNumber").val();
		var nPin = $("#nPin").val();
		
		if (isNaN(dTotalCost) || dTotalCost <= 0 || isNaN(nAcctNumber) || isNaN(nRoutingNumber) || isNaN(nPin)){

			alert("Please make sure your bank information is in the correct format and try again");
		} else {
			$.ajax
            ({
                type: "POST",
                url: '../Bank/PostTransaction',
                dataType: 'json',
                data:{ 	
				"nAccountNumber":nAcctNumber,
				"nRoutingNumber":nRoutingNumber,
				"dCost":dTotalCost,
				"nPin":nPin
						},
                success: function (data) {

					if (data.bSuccess){
						UpdateBooking();
					} else {
						$(".ErrorMessage").html("We were unable to post your transction to your bank for the following reason: <BR>" +data.sMessage);						
					}
				},
				error: function(data){
					$(".ErrorMessage").html("Internal error while communicating with the banking server, please try again later");
				}
  			});
			
			
		}

		
		
	}
	
	function UpdateBooking(){
		$.ajax
        ({
            type: "POST",
            url: '<c:url value='TransactionConfirmation'/>',
            dataType: 'json',
            data:{ 	
				"bSubmit":true
			},
            success: function (data) {
				$(".ErrorMessage").html(data.sMessage);
			},
			error: function(data){
				$(".ErrorMessage").html("Internal Error retrieving your flight, please try again later.");
			}
		});

	}
	
	
	
	
	
	
	
	
	function Cancel() {
		window.location.replace("FlightSearch.jsp");
	}





</script>
</html>