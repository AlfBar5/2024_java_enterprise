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
	
<div class="row">
    <div class="col-md-4 order-md-2 mb-4"></div>
	
	<div class="col-md-4 order-md-2 mb-4" align="center"><a href="guardarproduct.html"><h5>NUEVO PRODUCTO</h5> </a></div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</div>

<br>
<br>
<%List<Producto> resultados =(List<Producto>)request.getAttribute("result"); %>
	
<div class="row">
    <div class="col-md-2 order-md-2 mb-2"> </a></div>
	
	<div class="col-md-8 order-md-2 mb-8">
	<table class='table table-light'>
	<%if(resultados!=null){ %>
		<%for(Producto r:resultados) {%>
		<tr>     
	       <td style="text-align:center;"><%=r.getNombre() %></td>
	       <td style="text-align:center;"><%=r.getPrecio() %></td>
	       <td style="text-align:center;"><form action="BuscarProductos" method="POST">
	       <input type="hidden" name="categoria" class="form-control" value="<%=r.getCategoria() %>"><button type="submit" class=""><%=r.getCategoria() %></button> </form>
	      </td>
	       <td style="text-align:center;"> <form action="EliminarServlet" method="POST">
	       <input type="hidden" name="nombre" class="form-control" value="<%=r.getNombre() %>"><button type="submit" class="btn btn-primary">ELIMINAR</button> </form>
	       </td>
	      </tr>
	    <%} %>
	 <%} %>
	 </table>
	</div>

	<div class="col-md-2 order-md-2 mb-2"></div>

</div>

</body>
</html>
