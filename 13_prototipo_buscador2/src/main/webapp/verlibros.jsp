<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Resultado,java.util.List" %>

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
	
	<div align="center"><h5></h5></div>
	<br><br>

<%--RECOGEMOS LA FICHA DE UN ATRIBUTO DE PETICIÓN (mandado por el servlet login.java)--%>
<%--hay que hacer un casting para convertir el objeto Object en Ficha (Ficha)--%>
<%--hay que importar el model.Ficha arriba en la directiva page ==> import="model.Ficha" --%>
	<%--ArrayList<Resultado> resultados = new ArrayList<>();--%>
	<%-- --%>
	<%List<Resultado> resultados =(List<Resultado>)request.getAttribute("result"); %>
    
<%--recuperamos los datos de la ficha --%>
	
<table class="table">
  <thead>
    <tr>
      <th scope="col" style="text-align:center;">Resultados</th>
      <th scope="col" style="text-align:center;"> </th>
     
    </tr>
  </thead>
  <tbody>
   
    
   <%for(Resultado r:resultados) {%>
     <tr>     
       <td style="text-align:center;"><%=r.getTematica() %></td>
       <td style="text-align:center;"><%=r.getDescripcion() %></td>
       <td style="text-align:center;"><a href="<%=r.getUrl() %>" target="_blank"><%=r.getUrl() %></a></td>
      </tr>
    <%} %>
  
  </tbody>
</table>
<br><br>

<div align="center"><a href='buscadorlibros.html'>VOLVER</a></div>
	
<br><br>




		
	</div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</body>
</html>