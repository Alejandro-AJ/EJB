import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;


public class Insertar extends HttpServlet
{

  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
   PrintWriter out=response.getWriter();   

  String id=request.getParameter("id");
  String nombre=request.getParameter("nombre");
  String costo=request.getParameter("costo");
  //String opc=request.getParameter("opc");
  //int opcI = Integer.parseInt(opc); 

  //out.println(opcI);

  //if(opcI==1){
    String query="INSERT INTO platillos VALUES ("+id+",'"+nombre+"',"+costo+")";
    
    
  String url="jdbc:postgresql://127.0.0.1/basedatos";
  Connection con=null;

try{
         

          Class.forName("org.postgresql.Driver");
          con=DriverManager.getConnection(url,"harold","123");
          Statement inst= con.createStatement();
          inst.executeUpdate(query);
          request.getRequestDispatcher("./exito.jsp").forward(request,response);
}catch(Exception e){

         request.getRequestDispatcher("./error.jsp").forward(request,response);
}
 /*}else{
       String query="Select * from platillos where id="+id;
       String men1="",men2="",men3="";
  String url="jdbc:postgresql://127.0.0.1/basedatos";
  Connection con=null;

try{
         

          Class.forName("org.postgresql.Driver");
          con=DriverManager.getConnection(url,"harold","123");
          Statement inst= con.createStatement();
          ResultSet rs = inst.executeQuery(query); 
          while( rs.next()){
          men1=men1+String.valueOf(rs.getInt("id"));
          men2=men2+rs.getString("nombre");
          men3=men3+String.valueOf(rs.getInt("precio"));
          }
          request.setAttribute("ID",men1);
          request.setAttribute("NOMBRE",men2);
          request.setAttribute("PRECIO",men3);
          RequestDispatcher vista=request.getRequestDispatcher("./exito2.jsp");
          vista.forward(request,response);
}catch(Exception e){
          request.setAttribute("ERROR",e.getMessage());
          request.getRequestDispatcher("./error2.jsp").forward(request,response);
}

    }*/


   

  }

}
