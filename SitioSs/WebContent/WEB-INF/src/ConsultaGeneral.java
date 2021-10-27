import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
import misclases.Platillo;

public class ConsultaGeneral extends HttpServlet
{
  public void service(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException
  {
    String url="jdbc:postgresql://127.0.0.1:5432/basedatos";
    Connection con=null;
    String query="SELECT * FROM platillos ORDER BY id";
    try
    {    
      Class.forName("org.postgresql.Driver");
      con=DriverManager.getConnection(url,"harold","123");
      Statement inst=con.createStatement();
      ResultSet rs=inst.executeQuery(query);
      ArrayList L=new ArrayList();
      while (rs.next())
      {
        int id = rs.getInt(1);
        String nombre = rs.getString(2).trim();
        double precio= rs.getDouble(3);
        Platillo P=new Platillo();
        P.setId(id);
        P.setNombre(nombre);
        P.setPrecio(precio);
        L.add(P);
      }
      con.close();
      inst.close();
      request.setAttribute("PLATILLOS",L);
      request.getRequestDispatcher("./DespliegaConsultaGeneral.jsp").forward(request, response); 
    }
    catch(Exception exc)
    {
    }
  }
} 
