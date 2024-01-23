<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib uri="jakarta.tags.core" prefix="c" %> 




<!DOCTYPE html>
<html>
<head>
<!-- los siguiente metas son para no- cache -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<meta charset="UTF-8">

<title>Temas</title>

<!-- Bootstrap core CSS -->
<!-- Grid https://getbootstrap.com/docs/4.0/examples/grid/ -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	
	<!-- ajax -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	

	
</head>

<body>

<br><br>







<div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4" align="center"> 
        <label for="country">Temas</label>
                <select id="temaSel" class="custom-select d-block w-100"  >
                
                  <option value="">Seleccionar una opción:</option>
                  <option value="0">TODOS</option>
                  
                 <c:forEach var="t" items="${requestScope.temas}">
					<option value="${t.idTema}">${t.tema}</option>
				</c:forEach>
                  
                </select>  
           </div>
        <div class="col-md-4"></div>
</div>




<div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4" align="center"> 
        
        <div class="row">
			<div class="col-md-12 order-md-12 mb-12"><div id="tbLibros"></div> </div>
		</div>
        
        </div>
        <div class="col-md-4"></div>
</div>




<script type="text/javascript">
		$("#temaSel").change(function(){
			var url="FrontController";
			var params={"operation":"doLibros","idTema":$("#temaSel").val()};
			gestionarPeticion(url,params);
		});
	
	function gestionarPeticion(url,params){
		$.get(url,params,function(data){
			var tabla="<br><br><table class='table'><tr><th>Titulo</th><th>Precio</th><th>Páginas</th></tr>";
			$.each(data,function(i,p){
				tabla+="<tr><td>"+p.titulo+"</td><td>"+p.precio+"</td><td>"+p.paginas+"</td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	}
		
	
	</script>





</body>
</html>