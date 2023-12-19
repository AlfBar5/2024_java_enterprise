<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


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

<!-- Recogemos variable -->
<%int num=Integer.parseInt(request.getParameter("numero")); %>

	

			
<table class="table">
  <thead>
    <tr>
      <th scope="col" style="text-align:center;">Tabla del: <%=num%></th>
      <th scope="col" style="text-align:center;">Resultado: </th>
     
    </tr>
  </thead>
  <tbody>
   
      <%for(int n=1;n<=9;n++){%>
       <tr>
      <td style="text-align:center;"><%=n%> x  <%=num%></td> 
       <td style="text-align:center;"><%=n*num%></td>
      </tr>
      <%}%>	
    
  
  </tbody>
</table>
<br><br>

<div align="center"><a href='./numero.html'>VOLVER</a></div>


		
	</div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</body>
</html>