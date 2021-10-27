<HTML>
<center>
<BODY bgcolor="#FFDDDD">
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "misclases.Platillo" %>
<% 
   ArrayList L=(ArrayList)request.getAttribute("PLATILLOS");
%>
<h1>DESPLEGANDO LA CONSULTA</h1>
<table>
<% 
   boolean cambio=true;
   Platillo P;
   Iterator i = L.iterator();
   while(i.hasNext())
   {
      P=(Platillo)i.next();
      if (cambio)
      {
%>
        <tr bgcolor="#EEFFEE">
<%
      }
      else
      {
%>
        <tr bgcolor="#AADDAA">
<%
      }
%>
          <td><%= P.getId() %></td>
          <td><%= P.getNombre() %></td>
          <td><%= P.getPrecio() %></td>
        </tr>
<%
      cambio=!cambio;
   }
%>
</table>
</BODY>
</center>
</HTML>
