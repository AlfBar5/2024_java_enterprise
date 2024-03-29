package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recogemos parámetro
		String op=request.getParameter("operation");
		
		//variable para dirección de la vista
		String urlView="";
		
		switch(op) {
			case "doAlta":
				//include transfiere a otro controller y vuelve a la página de origen, a alta
				request.getRequestDispatcher("AltaController").include(request, response);
				//página que tiene que verse después de pasar por el controller
				urlView="inicio.html";
				break;
			case "doBuscarProducto":
				request.getRequestDispatcher("BuscarProductoController").include(request, response);
				//página que tiene que verse después de pasar por el controller
				urlView="producto.jsp";
				break;
			case "doBuscar":
				request.getRequestDispatcher("BuscarController").include(request, response);
				urlView="productos.jsp";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarController").include(request, response);
				urlView="inicio.html";
				break;
			case "toAlta":
				urlView="alta.html";
				break;
			case "toBuscarProducto":
				urlView="buscarproducto.html";
				break;
			case "toBuscar":
				urlView="buscar.html";
				break;
			case "toEliminar":
				urlView="eliminar.html";
				break;
			case "toInicio":
				urlView="inicio.html";
				break;
		}
		//forward transfiere a otro controller y no vuelve
		request.getRequestDispatcher(urlView).forward(request, response);
		
	}

}
