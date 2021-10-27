<html> 
 <center>

     <h1>Calculos</h1>

<%
   
     double sumaI=(Double)request.getAttribute("suma");
     double multI=(Double)request.getAttribute("multi");
     double resI=(Double)request.getAttribute("res");
     double divI=(Double)request.getAttribute("div");
%>


<h4>Suma: <%=String.format("%.3f",sumaI)%></h4>
<h4>Multiplicacion: <%=String.format("%.3f",multI)%></h4>
<h4>Resta: <%=String.format("%.3f",resI)%></h4>
<h4>Division: <%=String.format("%.3f",divI)%></h4>
  </center>
</html>


