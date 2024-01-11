package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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



@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// creo instancia de UsuariosService
		UsuariosService service= new UsuariosService();
		
		//guardo a true el resultado de la autentificación en variable result de tipo boolean
		boolean result = service.autenticar(request.getParameter("usuario"),request.getParameter("password"));
		
		//el resultado de la autentificación lo guadamos en una atributo de petición
		//para que lo pueda utilizar el FronController, aqui se guarda o true o false
		request.setAttribute("autenticado", result);
		
		//si result está autenticado lo guardamos también en un atributo de SESIÓN
		if(result) {
			request.getSession().setAttribute("usuario", request.getParameter("usuario"));
		}
		
		
		//el filtro se ejecuta en cada llamada. Si intentamos colarnos en cualquier página
		//sin estar autenticado, le mandamos a la página de login
		
	
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
