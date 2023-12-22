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
	
<h3>Has entrado individualmente: <%=session.getAttribute("contador") %></h3>
<br><br>
<h3>Se ha entrado globalmente: <%=application.getAttribute("contglobal") %></h3>

<br><br>
<%--Recogemos la cookie del request, la que tenga el cliente en su disco duro --%>
<%
String fecha;
fecha="Primera Visita.";
Cookie[] cookies=request.getCookies();

if(cookies!=null){
	for(Cookie cookie:cookies){
		if(cookie.getName().equals("fecha")){
			fecha=cookie.getValue();
		}
	}
	
}

%>
<h3>Fecha de tu anterior visita: <%=fecha %></h3>

<br><br>

<div align="center"><a href="inicio.html">VOLVER</a></div>


		
	</div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</body>
</html>
