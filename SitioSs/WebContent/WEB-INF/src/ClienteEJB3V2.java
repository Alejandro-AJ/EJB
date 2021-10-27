import java.io.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import calculator.RemoteCalculator;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;

public class ClienteEJB3V2 extends HttpServlet
{
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
   PrintWriter out=response.getWriter();   

   String uno=request.getParameter("numeroP");
   double NumeroU=Double.parseDouble(uno);
   String dos=request.getParameter("numeroS");
   double NumeroD=Double.parseDouble(dos);


final Hashtable jndiProperties=new Hashtable();
jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
try{

final Context ctx = new InitialContext(jndiProperties);
RemoteCalculator frijol = (RemoteCalculator) ctx.lookup("ejb:/calcale//CalculatorBean!calculator.RemoteCalculator");

request.setAttribute("suma",frijol.add(NumeroU,NumeroD));
request.setAttribute("multi",frijol.multiply(NumeroU,NumeroD));
request.setAttribute("res",frijol.subtract(NumeroU,NumeroD));
request.setAttribute("div",frijol.div(NumeroU,NumeroD));

RequestDispatcher vista=request.getRequestDispatcher("./Salida.jsp");
vista.forward(request,response);
ctx.close();
}
catch (Exception ex) {
out.println("El error es: "+ex.getMessage());

}
} // service
} // class
