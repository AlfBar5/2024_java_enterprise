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
	
<%for(int i=1;i<=9;i++){%>
			
<table class="table">
  <thead>
    <tr>
      <th scope="col" style="text-align:center;">Tabla del: <%=i%></th>
      <th scope="col" style="text-align:center;">Resultado: </th>
     
    </tr>
  </thead>
  <tbody>
   
      <%for(int n=1;n<=9;n++){%>
       <tr>
      <td style="text-align:center;"><%=n%> x <%=i%></td> 
       <td style="text-align:center;"><%=n*i%></td>
      </tr>
      <%}%>	
    
  
  </tbody>
</table>
<br><br>
<%}%>	

		
	
		
	</div>

	<div class="col-md-4 order-md-2 mb-4"></div>

</body>
</html>