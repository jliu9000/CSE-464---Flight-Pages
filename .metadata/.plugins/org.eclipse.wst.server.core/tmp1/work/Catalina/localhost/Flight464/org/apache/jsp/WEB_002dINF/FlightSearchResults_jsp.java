package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.*;
import flight.bizlogic.User;

public final class FlightSearchResults_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
	String sMessage;
	sMessage = (String) request.getAttribute("sMessage");
	if(sMessage == null || sMessage.equals("")){
		sMessage = "";
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/FlightStyles.css\">\r\n");
      out.write("<title>Flight Search Results</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='sidebar' class='sidebar'>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");
  
		if (request.getAttribute("Count") == null || request.getAttribute("SearchResults") == null){
			response.sendRedirect("FlightSearch.jsp");
		}
	  	
		Integer nTotalRecords;
	  	nTotalRecords = (Integer) request.getAttribute("Count");  	
	  	
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      flight.bizlogic.FlightRecordList SearchResults = null;
      synchronized (request) {
        SearchResults = (flight.bizlogic.FlightRecordList) _jspx_page_context.getAttribute("SearchResults", PageContext.REQUEST_SCOPE);
        if (SearchResults == null){
          SearchResults = new flight.bizlogic.FlightRecordList();
          _jspx_page_context.setAttribute("SearchResults", SearchResults, PageContext.REQUEST_SCOPE);
        }
      }
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"main\">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<p class=\"PageTitle\">Flight Search Results</p>\r\n");
      out.write("\t\t<p class=\"subheading\"><b>");
      out.print(nTotalRecords );
      out.write("</b> Results Found</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class='ErrorMessage'>");
      out.print(sMessage );
      out.write("</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<TR>\r\n");
      out.write("\t\t\t\t<th>Flight ID</th>\r\n");
      out.write("\t\t\t\t<th>Date</th>\r\n");
      out.write("\t\t\t\t<th>Departure Time</th>\r\n");
      out.write("\t\t\t\t<th>Arrival Time</th>\r\n");
      out.write("\t\t\t\t<th>Number of Stops</th>\r\n");
      out.write("\t\t\t\t<th>Cost</th>\r\n");
      out.write("\t\t\t\t<th>Additional Details</th>\r\n");
      out.write("\t\t\t</TR>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");
for (int i = 0; i<nTotalRecords; i++){
      out.write("\r\n");
      out.write("\t\t\t<tr class='");
      out.print( i % 2 == 1 ? "repeatalt" : "repeat" );
      out.write("'>\r\n");
      out.write("\t\t\t\t<TD> ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecordList)_jspx_page_context.findAttribute("SearchResults")).getFlightId())));
      out.write(" </TD>\r\n");
      out.write("\t\t\t\t<TD> ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecordList)_jspx_page_context.findAttribute("SearchResults")).getDate())));
      out.write(" </TD>\r\n");
      out.write("\t\t\t\t<TD> ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecordList)_jspx_page_context.findAttribute("SearchResults")).getDepartureTime())));
      out.write(" </TD>\r\n");
      out.write("\t\t\t\t<TD> ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecordList)_jspx_page_context.findAttribute("SearchResults")).getArrivalTime())));
      out.write(" </TD>\r\n");
      out.write("\t\t\t\t<TD> ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecordList)_jspx_page_context.findAttribute("SearchResults")).getNumberOfStops())));
      out.write(" </TD>\r\n");
      out.write("\t\t\t\t<TD> ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecordList)_jspx_page_context.findAttribute("SearchResults")).getCost())));
      out.write(" </TD>\r\n");
      out.write("\t\t\t\t<TD class='button'>\t\r\n");
      out.write("\t\t\t\t\t<form action=\"FlightSearchResults\" method=post>\r\n");
      out.write("\t\t\t\t\t\t<input type='hidden' id='nFlightId' value='");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecordList)_jspx_page_context.findAttribute("SearchResults")).getIdAndIncrement())));
      out.write("'>\r\n");
      out.write("\t\t\t\t\t\t<input type='submit' value='View and Book'>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
