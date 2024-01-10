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
		
		//String checkrecordar = request.getParameter("recordar").toString();
		
		
		// creo instancia de UsuariosService
		UsuariosService service= new UsuariosService();
		//RequestDispatcher dispatcher = null;
		
		//si la autentificación es true
		if(service.autenticar(request.getParameter("usuario"),request.getParameter("password"))){
				
			//GUARDAMOS el resultado de la autentificación EN UN ATRIBUTO DE PETICIÓN 
			request.setAttribute("autenticado", true);
			
			//if (recordar !=null) {
				//todo el código está en el método private generarCookie
				generarCookie(response,request.getParameter("usuario"));
				
			//}		
				
										
		}else {
			
			request.setAttribute("autenticado", false);
		}
	
		
		////OTRA FORMA EN UNA LINEA sin el if else
		//request.setAttribute("autenticado", service.autenticar(request.getParameter("usuario"),request.getParameter("password")));
		
	
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
