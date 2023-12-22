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
      <div class="col-md-3 order-md-2 mb-4"> 
        
     </div>
	
	<div class="col-md-6 order-md-2 mb-4">
	
	<h5>El usuario <%=request.getParameter("usuario")%> con contraseña <%=request.getParameter("password")%>, no existe</h5>



<br><br>

<div align="center"><a href='./login.html'>VOLVER</a></div>


		
	</div>

	<div class="col-md-3 order-md-2 mb-4"></div>

</body>
</html>