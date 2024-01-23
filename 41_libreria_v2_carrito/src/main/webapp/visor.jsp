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
        <div class="col-md-3"></div>
        <div class="col-md-6" align="center"> 
        
        <div class="row">
			<div class="col-md-12 order-md-12 mb-12"><div id="tbLibros" class="table-responsive"></div> </div>
		</div>
        
        </div>
        <div class="col-md-3"></div>
</div>





<div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6" align="center"> 
        
        <div class="row"><h4></h4><br>
			<div class="col-md-12 order-md-12 mb-12"><div id="tbCarrito" class="table-responsive"></div> </div>
		</div>
        
        </div>
        <div class="col-md-3"></div>
</div>



<script type="text/javascript">

	$("#temaSel").change(function(){
			var url="FrontController";
			var params={"operation":"doLibros","idTema":$("#temaSel").val()};
			gestionarPeticion(url,params);
	});
	
	function gestionarPeticion(url,params){
		$.get(url,params,function(data){
			var tabla="<br><br><table class='table table-striped table-sm' ><tr><th>ISBN</th><th>TÍTULO</th><th>AUTOR</th><th>PRECIO</th><th>PÁGINAS</th><th>CATEGORÍA</th><th></th></tr>";
			$.each(data,function(i,p){
				tabla+="<tr><td>"+p.isbn+"</td><td>"+p.titulo+"</td><td>"+p.autor+"</td><td>"+p.precio+"</td><td>"+p.paginas+"</td><td>"+$("#temaSel option:selected").text()+"</td><td><a href='#' onclick='agregarCarrito("+p.isbn+")'>Agregar</a></td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	}
	
	
	//pasamos la posición (i) en lugar de dato (p)
	function agregarCarrito(isbn){
		
		var params={"operation":"doAgregarCarrito","isbn":isbn};
		pintarCarrito(params);
		
	}
		
	
	//pasamos la posición (i) en lugar de dato (p)
	function quitarCarrito(pos){
		
		var params={"operation":"doQuitarCarrito","pos":pos};
		pintarCarrito(params);
			
		}	
		
	
	//Esto lo ponemos en una función aparte para ahorrar código
	function pintarCarrito(params){
		
		var url="FrontController";
		$.get(url,params,function(data){
			var tabla="<br><br><table class='table table-striped table-sm'><tr><th>ISBN</th><th>TÍTULO</th><th>AUTOR</th><th>PRECIO</th><th>PÁGINAS</th><th></th></tr>";
			$.each(data,function(i,p){
			tabla+="<tr><td>"+p.isbn+"</td><td>"+p.titulo+"</td><td>"+p.autor+"</td><td>"+p.precio+"</td><td>"+p.paginas+"</td><td><a href='#' onclick='quitarCarrito("+i+")'>Quitar</a></td></tr>";
		});
		tabla+="</table>";
		$("#tbCarrito").html(tabla);
		
	});
		
}
	
	</script>





</body>
</html>