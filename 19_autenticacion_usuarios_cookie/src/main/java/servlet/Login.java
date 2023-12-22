package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String checkrecordar = request.getParameter("recordar").toString();
		
		
		// creo instancia de UsuariosService
		UsuariosService service= new UsuariosService();
		RequestDispatcher dispatcher = null;
		
		if(service.autenticar(request.getParameter("usuario"),request.getParameter("password"))){
				//transferimos petición a correcto .jsp
			
			//if (checkrecordar!=null) {
				//todo el código está en el método private generarCookie
				generarCookie(response,request.getParameter("usuario"));
				
			//}		
				
			dispatcher=request.getRequestDispatcher("correcto.jsp");
			
									
		}else {
				//transferimos petición a error.jsp
				dispatcher=request.getRequestDispatcher("error.jsp");
			
		}
	
		dispatcher.forward(request, response);
	
	}
	
	
	//método privado
			private void generarCookie(HttpServletResponse response,String usuario) {
				
				//Creamos cookie
				Cookie cookie= new Cookie("usuario", usuario);
				//establecemos tiempo de vida de la cookie
				cookie.setMaxAge(10_000_000);
				
				response.addCookie(cookie);
				
				
			}
	

}
