<html> 
 <center>

     <h1>Calculos Triangulo</h1>

<%
   
     double baseI=(Double)request.getAttribute("base");
     double alturaI=(Double)request.getAttribute("altura");
     double periI=(Double)request.getAttribute("perimetro");
     double areaI=(Double)request.getAttribute("area");
%>


<h4>Base: <%=String.format("%.3f",baseI)%></h4>
<h4>Altura: <%=String.format("%.3f",alturaI)%></h4>
<h4>Perimetro: <%=String.format("%.3f",periI)%></h4>
<h4>Area: <%=String.format("%.3f",areaI)%></h4>
  </center>
</html>


