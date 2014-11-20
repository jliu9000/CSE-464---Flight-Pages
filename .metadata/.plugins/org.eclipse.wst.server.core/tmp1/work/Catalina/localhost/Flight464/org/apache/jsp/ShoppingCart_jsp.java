package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import flight.bizlogic.User;

public final class ShoppingCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/LoginHelper.jsp");
    _jspx_dependants.add("/WEB-INF/ErrorMessageHelper.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
 
	
	
	User user = null;
	
	user = (User) session.getAttribute("User");
	
	
	
	if (user == null){
		request.setAttribute("sMessage", "Please login to view any flight pages");
		request.getRequestDispatcher("./Login.jsp").forward(request,response);
	}


      out.write('\r');
      out.write('\n');
 
	String sMessage = "";
	sMessage = (String) request.getAttribute("sMessage");
	if(sMessage == null || sMessage.equals("")){
		sMessage = "";
	}

      out.write(' ');
      out.write("\r\n");
      out.write("   \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("\t");
  
		int nTotalRecords = 0;
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) session.getAttribute("ShoppingCart");
		if (alRecords == null){
			sMessage = "Shopping Cart is empty";
		} else {
			nTotalRecords = alRecords.size();
		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='sidebar' class='sidebar'>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div class='main'>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<p class=\"PageTitle\">Shopping Cart</p>\r\n");
      out.write("\t\t<p class=\"subheading\"><b>");
      out.print(nTotalRecords );
      out.write("</b> Results Found</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class='ErrorMessage'>");
      out.print(sMessage );
      out.write("</div>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<TR>\r\n");
      out.write("\t\t\t\t<th>Flight ID</th>\r\n");
      out.write("\t\t\t\t<th>Date</th>\r\n");
      out.write("\t\t\t\t<th>Departure Time</th>\r\n");
      out.write("\t\t\t\t<th>Arrival Time</th>\r\n");
      out.write("\t\t\t\t<th>Number of Stops</th>\r\n");
      out.write("\t\t\t\t<th>Cost</th>\r\n");
      out.write("\t\t\t\t<th>Number of Seats</th>\r\n");
      out.write("\t\t\t</TR>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");

				FlightRecord frTemp;
			
				for (int i = 0; i<nTotalRecords; i++){
      out.write("\r\n");
      out.write("\t\t\t\t<tr class='");
      out.print( i % 2 == 1 ? "repeatalt" : "repeat" );
      out.write("'>\r\n");
      out.write("\t\t\t\t\t");
 frTemp = alRecords.get(i);  
      out.write("\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getnID() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getsDateOfTravel() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getsDepartureTime() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getsArrivalTime() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getnNumberOfStops() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getdCost() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t<select name=\"");
      out.print(i );
      out.write("\" id=\"Select\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
 for (int j=0; j<=frTemp.getnSeats(); j++) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
if(j == frTemp.getnNumSelectedSeats()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(j );
      out.write("\" selected=\"selected\">");
      out.print(j );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t");
 }else{
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(j );
      out.write('"');
      out.write('>');
      out.print(j );
      out.write("</option>");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<form action='ViewAndBook' method=post>\r\n");
      out.write("\t\t<input type=\"hidden\" value=\"true\" name=\"submit\" />\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Checkout\" style=\"font-weight:bold;\"></input>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction SelectedChanged(SelectTag){\r\n");
      out.write("\t\t//alert(SelectTag);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$('Select').change(function () {\r\n");
      out.write("\t     var optionSelected = $(this).find(\"option:selected\");\r\n");
      out.write("\t     var valueSelected  = optionSelected.val();\r\n");
      out.write("\t     var textSelected   = optionSelected.text();\r\n");
      out.write("\t     var name = $(this).attr('name');\r\n");
      out.write("\t     var dataString = \"UpdateCart=\" + name + \"&Value=\" + textSelected; \r\n");
      out.write("\t     \r\n");
      out.write("\t     $.ajax({\r\n");
      out.write("\t\t\t\ttype: \"POST\",  \r\n");
      out.write("\t\t\t\turl: \"ShoppingCart\",\r\n");
      out.write("\t\t\t\tdata: dataString,\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t     \r\n");
      out.write("\t     \r\n");
      out.write("\t     alert(name);\r\n");
      out.write("\t });\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
