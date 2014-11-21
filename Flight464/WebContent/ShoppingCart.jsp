<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="flight.bizlogic.*, java.util.ArrayList, javax.servlet.http.HttpSession"%>
<%@ include file="WEB-INF/LoginHelper.jsp" %>
<%@ include file="WEB-INF/ErrorMessageHelper.jsp" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title></title>
</head>
	<%  
		int nTotalRecords = 0;
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) session.getAttribute("ShoppingCart");
		if (alRecords == null){
			sMessage = "Shopping Cart is empty";
		} else {
			nTotalRecords = alRecords.size();
		}
	%>

<body>
	<div id='sidebar' class='sidebar'>
        <jsp:include page="sidebar.jsp" />
	</div>

		
	<div class='main'>	
		
		<br><br>
		<p class="PageTitle">Shopping Cart</p>
		<p class="subheading"><b><%=nTotalRecords %></b> Items in Cart</p>
		
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
		<br><br>
		<form action='ViewAndBook' method=post>
		<input type="hidden" value="true" name="submit" />
		<% if (sMessage.equals("")){ %>
		<input type="submit" value="Checkout" style="font-weight:bold;"></input>
		<%} %>
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
				url: "ShoppingCart",
				data: dataString,
				})
	     
	     
	 });
	
</script>

</html>