package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ficha;
import service.UsuariosService;

import java.io.IOException;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// creo instancia de UsuariosService
		UsuariosService service= new UsuariosService();
		
		RequestDispatcher dispatcher;
		if(service.autenticar(request.getParameter("usuario"),request.getParameter("password"))){
				
				//Si estamos autenticados, debemos crear la ficha
				Ficha ficha= service.fichaUsuario(request.getParameter("usuario"));
				//GUARDAMOS LA FICHA EN UN ATRIBUTO DE PETICIÓN (y lo mandamos a la página de destino)
				request.setAttribute("fichauser", ficha);
			
				//transferimos petición a correcto .jsp
				dispatcher=request.getRequestDispatcher("correcto.jsp");
				
				
		}else {
				//transferimos petición a error.jsp
				dispatcher=request.getRequestDispatcher("error.jsp");
			
		}
		dispatcher.forward(request, response);
						
		
		
	}

}
