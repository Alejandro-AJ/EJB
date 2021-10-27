import java.io.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import figuras.TrianguloRemote;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;

public class ClienteEJB3V2Stateful extends HttpServlet
{
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
   PrintWriter out=response.getWriter();   

   String base=request.getParameter("base");
   double baseU=Double.parseDouble(base);
   String altura=request.getParameter("altura");
   double alturaD=Double.parseDouble(altura);


final Hashtable jndiProperties=new Hashtable();
jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
try{
final Context ctx = new InitialContext(jndiProperties);
TrianguloRemote frijol = (TrianguloRemote) ctx.lookup("ejb:/ctale//TrianguloBean!figuras.TrianguloRemote?stateful");

frijol.setBase(baseU);
frijol.setAltura(alturaD);
request.setAttribute("base",frijol.getBase());
request.setAttribute("altura",frijol.getAltura());
request.setAttribute("perimetro",frijol.perimetro());
request.setAttribute("area",frijol.area());
RequestDispatcher vista=request.getRequestDispatcher("./Salida.jsp");
vista.forward(request,response);
ctx.close();
}
catch (Exception ex) {
System.out.println(ex.getMessage());
ex.printStackTrace();
}
} // service
} // class
