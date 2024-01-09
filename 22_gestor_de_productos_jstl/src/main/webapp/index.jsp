<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Producto,java.util.List"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestor de productos</title>

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

<h2>Productos de ${param.categoria} </h2>

<br>
<%--List<Producto> resultados =(List<Producto>)request.getAttribute("result"); --%>
	
<div class="row">
    <div class="col-md-2 order-md-2 mb-2"> </a></div>
	
	<div class="col-md-8 order-md-2 mb-8">
	<table class='table table-light'>
	
	<c:if test="${!empty sessionScope.resultados}">
		<c:forEach var="r" items="${requestScope.productos}">
		<tr>     
	       <td style="text-align:center;">${r.nombre}</td>
	       <td style="text-align:center;">${r.precio}</td>
	       <td style="text-align:center;"><form action="BuscarProductos" method="POST">
	       <input type="hidden" name="categoria" class="form-control" value="${r.nombre}"><button type="submit" class="">${r.categoria}</button> </form>
	      </td>
	       <td style="text-align:center;"> <form action="EliminarServlet" method="POST">
	       <input type="hidden" name="nombre" class="form-control" value="<${r.nombre}"><button type="submit" class="btn btn-primary">ELIMINAR</button> </form>
	       </td>
	      </tr>
	      
	      </c:forEach>
	 </c:if>
	 
	 </table>
	</div>

	<div class="col-md-2 order-md-2 mb-2"></div>

</div>

</body>
</html>
