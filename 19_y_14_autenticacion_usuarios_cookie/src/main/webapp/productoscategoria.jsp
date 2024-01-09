<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Producto,java.util.List"%>


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
	<%List<Producto> resultados =(List<Producto>)request.getAttribute("result"); %>
<div class="row">
    <div class="col-md-4 order-md-2 mb-4"></div>
	
	<div class="col-md-4 order-md-2 mb-4" align="center">Resultados de la categoría: </div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</div>

<br>
<br>

	
<div class="row">
    <div class="col-md-2 order-md-2 mb-2"> </a></div>
	
	<div class="col-md-8 order-md-2 mb-8">
	<table class='table table-light'>
	<%if(resultados!=null){ %>
		<%for(Producto r:resultados) {%>
		<tr>     
	       <td style="text-align:center;"><%=r.getNombre() %></td>
	       <td style="text-align:center;"><%=r.getPrecio() %></td>
	       <td style="text-align:center;"><%=r.getCategoria() %></td>
	      
	      </tr>
	    <%} %>
	 <%} %>
	 </table>
	 
 <br><br>

<div align="center"><a href='index.jsp'>VOLVER</a></div>
	
<br><br>
	 
	 
	</div>

	<div class="col-md-2 order-md-2 mb-2"></div>

</div>

</body>
</html>
