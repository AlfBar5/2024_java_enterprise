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
		case "doTemas":
			request.getRequestDispatcher("TemasController").include(request, response);
			urlView="visor.jsp";
			break;
		case "doLibros":
			request.getRequestDispatcher("LibrosTemasController").forward(request, response);
			return; //en peticiones AJAX la respuesta la lleva a cabo
					//el servlet controlador
		}
		
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
