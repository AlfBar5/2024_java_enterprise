<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- los siguiente metas son para no- cache -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 

<title>Cursos</title>

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

<br>
<br>

	
<div class="row">
    <div class="col-md-2 order-md-2 mb-2"> </div>
	
	<div class="col-md-8 order-md-2 mb-8">
<br>
<br>
	<div align="center">Producto con ID: ${requestScope.producto.idProducto}</div>
<br>
<br>
	<table class='table table-light'>
	
	
	
	<thead>
      <tr>
      <th style="text-align:center;">ID PRODUCTO</th>
        <th style="text-align:center;">NOMBRE</th>
        <th style="text-align:center;">CATEGOR&Iacute;</th>
        <th style="text-align:center;">PRECIO</th>
      </tr>
    </thead>
	
	
	
		
	
	
	
		<tr>     
			<td style="text-align:center;">${requestScope.producto.idProducto}</td>
	       <td style="text-align:center;">${requestScope.producto.nombre}</td>
	       <td style="text-align:center;">${requestScope.producto.categoria}</td>
	       <td style="text-align:center;">${requestScope.producto.precio} Euros</td>
	       
	     
	      
	      </tr>
	      
	  
	     
	      
	
	   
	 </table>
	</div>

	<div class="col-md-2 order-md-2 mb-2"></div>

</div>


<div align="center"><a href="FrontController?operation=toInicio">VOLVER</a></div>

</body>
</html>

