package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		String urlView="";
		switch(operation) {
		case "doLogin":
			request.getRequestDispatcher("LoginController").include(request, response);
			//control de si el usuario está autentificado
			if(request.getAttribute("autenticado")!=null) {
				//le hacemos este request para que vaya al controlador TemasController
				request.getRequestDispatcher("TemasController").include(request, response);
				urlView="visor.jsp";
			}else {
				urlView="error.jsp";
			}
			break;
		
		case "doTemas":
			request.getRequestDispatcher("TemasController").include(request, response);
			urlView="visor.jsp";
			break;
			
		case "doLibros":
			request.getRequestDispatcher("LibrosTemasController").forward(request, response);
			return; //en peticiones AJAX la respuesta la lleva a cabo
					//el servlet controlador
			
		case "doAgregarCarrito":
			request.getRequestDispatcher("AgregaraCarritoController").forward(request, response);
			return; //en peticiones AJAX la respuesta la lleva a cabo
					//el servlet controlador
			
		case "doQuitarCarrito":
			request.getRequestDispatcher("EliminardeCarritoController").forward(request, response);
			return; //en peticiones AJAX la respuesta la lleva a cabo
					//el servlet controlador
			
		case "doAltaCliente":
			request.getRequestDispatcher("AltaController").include(request, response);
			urlView="inicio.html";
			break;
						
		case "toLogin":
			urlView="inicio.html";
			break;
			
		case "toAltaCliente":
			urlView="altacliente.html";
			break;
			
		}
		
			
			
		request.getRequestDispatcher(urlView).forward(request, response);
		
	}

}
