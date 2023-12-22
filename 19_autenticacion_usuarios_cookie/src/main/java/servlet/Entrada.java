package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

//IMPORTAR ESTA LÍNEA
import jakarta.servlet.http.Cookie;



@WebServlet("/Entrada")
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*
		// Comprobar si llega la cookie "user", programación tradicional
		String usuario=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie ck:cookies) {
				if(ck.getName().equals("usuario")) {
					usuario=ck.getValue();
					break;
				}
			}
		}
*/
		
		//con programación funcional
		String usuario=Arrays.stream(request.getCookies()!=null?request.getCookies():new Cookie[0])
				.filter(c->c.getName().equals("usuario"))
				.findFirst().orElse(new Cookie("usuario",null))
				.getValue();
		
		
		if(usuario==null) {
			//no hay cookies
			request.getRequestDispatcher("login.html").forward(request, response);
			
		}else {
			//transferimos petición a correcto.jsp con nombre de usuario
			request.getRequestDispatcher("correcto.jsp?usuario="+usuario).forward(request, response);
		}
		
	}
		
	

}
