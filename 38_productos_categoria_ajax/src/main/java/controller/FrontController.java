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
		//String urlView="";
		
		switch(op) {
			//forward, es ida sin vuelta
			case "doBuscar":
				request.getRequestDispatcher("BuscarController").forward(request, response);
				return;
			
		}
		
		//forward transfiere a otro controller y no vuelve. 
		//request.getRequestDispatcher(urlView).forward(request, response);
		
	}

}
