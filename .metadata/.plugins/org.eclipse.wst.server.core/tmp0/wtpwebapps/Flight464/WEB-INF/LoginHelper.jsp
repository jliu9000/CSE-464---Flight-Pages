<%@ page import="flight.bizlogic.Clients"%>
<% 

	Clients oClient = null;
	oClient = (Clients) session.getAttribute("Clients");

	if (oClient == null){
		request.setAttribute("sMessage", "Please login to view any flight pages");
		request.getRequestDispatcher("./Login.jsp").forward(request,response);
	}

%>