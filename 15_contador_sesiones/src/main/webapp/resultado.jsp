<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contador por session</title>

<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<br><br>

<div class="row">
      <div class="col-md-4 order-md-2 mb-4"> 
        
     </div>
	
	<div class="col-md-4 order-md-2 mb-4">
	
	<h3>Has entrado: <%=session.getAttribute("contador") %></h3>



<br><br>

<div align="center"><a href="inicio.html">VOLVER</a></div>


		
	</div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</body>
</html>
