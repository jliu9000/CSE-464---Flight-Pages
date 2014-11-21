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
<title>Confirm Booking</title>
</head>

	<%  
		int nTotalRecords = 0;
		Double dTotalCost = 0.0;
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) session.getAttribute("ShoppingCart");
		if (alRecords == null){
			sMessage += "Unable to load your shopping cart transactions, please try again.<BR>";
		} else {
			nTotalRecords = alRecords.size();
		}
		dTotalCost = (Double) request.getAttribute("dTotalCost");
	%>
	
	
<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="../sidebar.jsp" />
	</div>

		
	<div class='main'>	
		
		<br><br>
		<p class="PageTitle">Confirm Booking</p>
		<p class="subheading"></p>
		
		<div class='ErrorMessage'><%=sMessage %></div>
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
					<td><%=frTemp.getnNumSelectedSeats() %></td>			
				</tr>
			<%} %>
			
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
					<td></td><td></td>
				</tr>
				<tr>
					<td class='button' colspan=2>	
						<button type="button" onclick="ConfirmTransaction()">Confirm</button>
				        &nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="Cancel()">Cancel</button>
					</td>
				</tr>
			</table>
			<input id='dTotalCost' value='<%=dTotalCost %>' type=hidden></input>
		
		
	</div>

</body>
<script>
	function ConfirmTransaction(){
		
		var dTotalCost = $("#dTotalCost").val();
		var nAcctNumber = $("#nAccountNumber").val();
		var nRoutingNumber = $("#nRoutingNumber").val();

		if (isNaN(dTotalCost) || dTotalCost <= 0 || isNaN(nAcctNumber) || isNaN(nRoutingNumber)){

			alert(dTotalCost, nAcctNumber);
		} else {
			$("#addToCart").prop("disabled",true);
			$.ajax
            ({
                type: "POST",
                url: '../Bank/PostTransaction',
                dataType: 'json',
                data:{ 	
				"nAccountNumber":nAcctNumber,
				"nRoutingNumber":nRoutingNumber,
				"dCost":dTotalCost
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
            url: 'TransactionConfirmation',
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