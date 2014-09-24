package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.RecordFactory;
import flight.bizlogic.FlightRecord;
import java.util.ArrayList;

public final class BookingHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Booking History</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class='sidebar'>\r\n");
      out.write("\t\t<a id=\"login\" href=\"Login.jsp\">\r\n");
      out.write("\t\t");
      out.print(session.getAttribute("nUserID") != null ? "Logout" : "Login");
      out.write("\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<a href=\"FlightSearch.jsp\"><button>Home</button></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t");
 RecordFactory rf = new RecordFactory(0);
			ArrayList<FlightRecord> oRecordsList;
			rf.generateRecords();
			
		 	oRecordsList = rf.getRecords();
		   //can add list of user's transactions here later on.
		 
      out.write("\r\n");
      out.write("\t\t \r\n");
      out.write("\t<div class='main'>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p class=\"PageTitle\">Booking History</p>\r\n");
      out.write("\t\t<p class=\"subheading\">");
      out.print(oRecordsList.size() );
      out.write(" Total Records</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<TR>\r\n");
      out.write("\t\t\t\t<th>Ticket Number: </th> <th> Flight Date </th>\r\n");
      out.write("\t\t\t</TR> \r\n");
      out.write("\t\t\t");
 for(FlightRecord r : oRecordsList) {
      out.write("\r\n");
      out.write("\t\t\t<TR>\r\n");
      out.write("\t\t\t\t<TD class='key'>");
      out.print(r.getID() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t<TD>");
      out.print(r.getDateOfTravel() );
      out.write("</TD>\r\n");
      out.write("\t\t\t</TR>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
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
