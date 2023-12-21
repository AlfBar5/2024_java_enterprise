<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Ficha"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saludo jsp</title>

<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<br><br>

<div class="row">
      <div class="col-md-4 order-md-2 mb-4"> 
        
     </div>
	
	<div class="col-md-4 order-md-2 mb-4">
	
	<div align="center"><h5>El usuario <%=request.getParameter("usuario")%> es válido</h5></div>
	<br><br>

<%--RECOGEMOS LA FICHA DE UN ATRIBUTO DE PETICIÓN (mandado por el servlet login.java)--%>
<%--hay que hacer un casting para convertir el objeto Object en Ficha (Ficha)--%>
<%--hay que importar el model.Ficha arriba en la directiva page ==> import="model.Ficha" --%>
	<%Ficha f =(Ficha)request.getAttribute("fichauser"); %>
    
<%--recuperamos los datos de la ficha --%>
	
<table class="table">
  <thead>
    <tr>
      <th scope="col" style="text-align:center;">Ficha de <%=request.getParameter("usuario") %></th>
      <th scope="col" style="text-align:center;">Datos: </th>
     
    </tr>
  </thead>
  <tbody>
   
    
       <tr>
      <td style="text-align:center;">Nombre:</td> 
       <td style="text-align:center;"><%=f.getUsuario() %></td>
      </tr>
     
      <tr>
      <td style="text-align:center;">Edad:</td> 
       <td style="text-align:center;"><%=f.getEdad() %></td>
      </tr>
      
       <tr>
      <td style="text-align:center;">Email:</td> 
       <td style="text-align:center;"><%=f.getEmail() %></td>
      </tr>
    
  
  </tbody>
</table>
<br><br>

<div align="center"><a href='login.html'>VOLVER</a></div>
	
<br><br>




		
	</div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</body>
</html>