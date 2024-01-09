package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recogemos parámetro
				String op=request.getParameter("operation");
				
				//variable para dirección de la vista
				String urlView="";
				
				switch(op) {
					case "doGuardar":
						//include transfiere a otro controller y vuelve a la página de origen, a alta
						request.getRequestDispatcher("GuardarController").include(request, response);
						//página que tiene que verse después de pasar por el controller
						urlView="nuevo.html";
						break;
					case "doBuscar":
						request.getRequestDispatcher("BuscarController").include(request, response);
						urlView="cursos.jsp";
						break;
					case "doEliminar":
						request.getRequestDispatcher("EliminarController").include(request, response);
						urlView="menu.html";
						break;
					case "toNuevo":
						urlView="nuevo.html";
						break;
					case "toBuscar":
						urlView="buscar.html";
						break;
					case "toEliminar":
						urlView="eliminar.html";
						break;
					case "toMenu":
						urlView="menu.html";
						break;
				}
				//forward transfiere a otro controller y no vuelve
				request.getRequestDispatcher(urlView).forward(request, response);
				
			
		
		
	}

}
