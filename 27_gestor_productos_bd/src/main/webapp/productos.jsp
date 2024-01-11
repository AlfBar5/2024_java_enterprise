<%@page import="model.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Producto, java.util.List"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>    




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- los siguiente metas son para no- cache -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 

<title>Productos</title>

<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<br><br>
	
<div class="row">
    <div class="col-md-4 order-md-2 mb-4"></div>
	
	<div class="col-md-4 order-md-2 mb-4" align="center"><a href="FrontController?operation=toInicio"><h5>VOLVER</h5> </a></div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</div>

	
<div class="row">
    <div class="col-md-2 order-md-2 mb-2"> </div>
	
	<div class="col-md-8 order-md-2 mb-8">
<br>
<br>
	<div align="center">Productos de ${param.categoria}</div>
<br>
<br>
	<table class='table table-light'>
	
	
	<c:if test="${!empty requestScope.productos}">	
	
	<thead>
      <tr>
       <th style="text-align:center;">ID PRODUCTO</th>
        <th style="text-align:center;">NOMBRE</th>
        <th style="text-align:center;">CATEGOR&Iacute;A </th>
        <th style="text-align:center;">PRECIO</th>
      </tr>
    </thead>
	
	
	
		
	
	<c:forEach var="pr" items="${requestScope.productos}">
		
		<tr>     
	       <td style="text-align:center;">${pr.idProducto}</td>
	       <td style="text-align:center;">${pr.nombre}</td>
	       <td style="text-align:center;">${pr.categoria}</td>
	       <td style="text-align:center;">${pr.precio} Euros</td>
	       
	     
	      
	      </tr>
	      
	      </c:forEach>
	     
	      
	</c:if>
	
	
	<c:if test="${empty requestScope.productos}">
	      <div align="center">No hay productos en esta categoría</div>
	</c:if>
	   
	 </table>
	</div>

	<div class="col-md-2 order-md-2 mb-2"></div>

</div>

</body>
</html>
