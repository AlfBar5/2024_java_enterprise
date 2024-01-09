<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Curso,java.util.ArrayList"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<br><br>
	
<div class="row">
    <div class="col-md-4 order-md-2 mb-4"></div>
	
	<div class="col-md-4 order-md-2 mb-4" align="center"><a href="menu.html"><h5>VOLVER</h5> </a></div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</div>

<br>
<br>
<%-- devuelve object, hay que hacer el casting   --%>
<%ArrayList<Curso> resultados =(ArrayList<Curso>)request.getAttribute("cursos"); %>
	
<div class="row">
    <div class="col-md-2 order-md-2 mb-2"> </div>
	
	<div class="col-md-8 order-md-2 mb-8">
<br>
<br>
	<div align="center">Cursos cuyo precio máximo es <%=request.getParameter("preciomax")%></div>
<br>
<br>
	<table class='table table-light'>
	
	<thead>
      <tr>
        <th style="text-align:center;">NOMBRE</th>
        <th style="text-align:center;">DURACIÓN EN HORAS</th>
        <th style="text-align:center;">PRECIO</th>
      </tr>
    </thead>
	
	
	
	<%if(resultados!=null){%>
		<%for(Curso r:resultados) {%>
		<tr>     
	       <td style="text-align:center;"><%=r.getNombre() %></td>
	       <td style="text-align:center;"><%=r.getDuracion() %></td>
	       <td style="text-align:center;"><%=r.getPrecio() %> Euros</td>
	       
	     
	      
	      </tr>
	    <%} %>
	 <%} %>
	 </table>
	</div>

	<div class="col-md-2 order-md-2 mb-2"></div>

</div>

</body>
</html>

