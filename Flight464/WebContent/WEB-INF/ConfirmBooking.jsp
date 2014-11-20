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
		<p class="PageTitle">Shopping Cart</p>
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
					<td> 
						<select name="<%=i %>" id="Select">
						
						<% for (int j=0; j<=frTemp.getnSeats(); j++) {%>
						<%if(j == frTemp.getnNumSelectedSeats()){ %>
							<option value="<%=j %>" selected="selected"><%=j %></option>
							
							<% }else{%> 
							<option value="<%=j %>"><%=j %></option><%} %>
						<%} %>
					</select>
					</td>			
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
		alert("clicked");
		
		var dTotalCost = $("#dTotalCost").val();
		var nAcctNumber = $("#nAccountNumber").val();
		var nRoutingNumber = $("#nRoutingNumber").val();
//		if (isNaN(dTotalCost) || dTotalCost <= 0 || isNaN(nAcctNumber) || isNaN(nRoutingNumber)){
		if (isNaN(dTotalCost) || dTotalCost <= 0 || isNaN(nAcctNumber) || isNaN(nRoutingNumber)){

			alert(dTotalCost, nAcctNumber);
		} else {
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
					alert(JSON.stringify(data));
				},
				error: function(data){
					alert("error");
				}
  			});
			
			
		}
		alert('done');
		
		
	}
	
	function Cancel() {
		window.location.replace("FlightSearch.jsp");
	}





</script>
</html>