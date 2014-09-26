package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./CSS/FlightStyles.css\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Registration</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='sidebar' class='sidebar'>\r\n");
      out.write("\t    <script>\r\n");
      out.write("            $(\"#sidebar\").load(\"sidebar.html\");\r\n");
      out.write("        </script>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class='main' style=\"width:750px\">\r\n");
      out.write("\t\t<p class='PageTitle'>Registration</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<form action=\"Registration\" method=\"post\" onsubmit=\"return formSubmit();\">\r\n");
      out.write("\t\t\t<table class=\"center\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" align=\"center\"><p class=\"TableHeader\">Please fill out the form to register</p></td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">User Name:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"txtUserName\" name=\"UserName\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">Password:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" id=\"txtPassword\" name=\"Password\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">Confirm Password:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" id=\"txtConfirmPassword\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" align=\"center\"><label id=\"lblErrorMessage\" style=\"visibility:hidden\" ><font color=\"red\" >Your Passwords do not match, Please Re enter them</font></label></td>\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" id=\"btnSubmitButton\" name=\"btnSubmitButton\" value=\"Submit\" style=\"display:hidden\"  />\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar typingTimer;\r\n");
      out.write("\t\tvar doneTypingInterval = 500;\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(\"#btnSubmitButton\").hide();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkEquality(){\r\n");
      out.write("\t\tvar password = document.getElementById('txtPassword').value;\r\n");
      out.write("\t\tvar confirmpassword = document.getElementById('txtConfirmPassword').value;\r\n");
      out.write("\t\tvar submitButton = document.getElementById('btnSubmitButton');\r\n");
      out.write("\t\tvar errorLabel = document.getElementById('lblErrorMessage');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (!(confirmpassword.toLowerCase()=== password.toLowerCase())){\r\n");
      out.write("\t\t\terrorLabel.style.visibility = \"visible\";\r\n");
      out.write("\t\t\t$(\"#btnSubmitButton\").hide();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\terrorLabel.style.visibility = \"hidden\";\r\n");
      out.write("\t\t\t$(\"#btnSubmitButton\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}//end checkEquality\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t$('#txtConfirmPassword').keyup(function(){\r\n");
      out.write("\t    clearTimeout(typingTimer);\r\n");
      out.write("\t    typingTimer = setTimeout(checkEquality, doneTypingInterval);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$('#txtPassword').keyup(function(){\r\n");
      out.write("\t    clearTimeout(typingTimer);\r\n");
      out.write("\t    typingTimer = setTimeout(checkEquality, doneTypingInterval);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tfunction formSubmit(){\r\n");
      out.write("\t\tvar password = document.getElementById('txtPassword').value;\r\n");
      out.write("\t\tvar confirmpassword = document.getElementById('txtConfirmPassword').value;\r\n");
      out.write("\t\tvar userName = document.getElementById('txtUserName').value;\r\n");
      out.write("\t\tif (!(/\\S/.test(password)) || !(/\\S/.test(confirmpassword)) || !(/\\S/.test(userName))){\r\n");
      out.write("\t\t\talert(\"The Form is not correct, please make sure you have a valid user name , and matching passwords\");\t\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else return true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
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
