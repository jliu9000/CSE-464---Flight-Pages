package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.*;

public final class ViewAndBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/FlightStyles.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>View and Book</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class='sidebar'>\r\n");
      out.write("\t<a id=\"login\" href=\"login.jsp\">\r\n");
      out.write("\t");
      out.print(session.getAttribute("nUserID") != null ? "Logout" : "Login");
      out.write("\r\n");
      out.write("\t</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t");
  
		RecordFactory records = new RecordFactory(1);
		FlightRecord r = records.TestRecord();
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<div class='main'>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<p class=\"PageTitle\">View and Book</p>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"RecordDetails\">\r\n");
      out.write("\t\t<p>Flight ID: ");
      out.print(r.getID() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Flight Date: ");
      out.print(r.getDateOfTravel() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Departure Time: ");
      out.print(r.getDepartureTime() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Departure Location: ");
      out.print(r.getSource() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Arrival Time: ");
      out.print(r.getArrivalTime() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Arrival Location: ");
      out.print(r.getDestination() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Number of Stops: ");
      out.print(r.getNumberOfStops() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Class: ");
      out.print(r.getFlightClass() );
      out.write("</p>\r\n");
      out.write("\t\t<p>Cost: $");
      out.print(r.getCost() );
      out.write("</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t\r\n");
      out.write("\t<a href=\"FlightSearchResults.jsp\"><button>Back</button></a>\r\n");
      out.write("\t<a href=\"Transaction.jsp\"><button>Select</button></a>\r\n");
      out.write("\t<a href=\"FlightSearch.jsp\"><button>Home</button></a>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
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
