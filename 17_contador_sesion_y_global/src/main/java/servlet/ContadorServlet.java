package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ContadorServlet")
public class ContadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//contador por sesión del usuario
		//Contador para todos lo usuarios que usen la aplicación	
			
				//2. SESIÓN pedimos HttpSession 
				HttpSession session=request.getSession();
				
				// 3 ATRIBUTOS DE APLICACIÓN
				ServletContext context=request.getServletContext();
				
				//recuperamos el contador, le sumamos 1 y lo volvemos a guardar
				//comprobando que sea distinto de null, en caso de ser nulo
				//se crea a cero
				int actual=0;
				if(session.getAttribute("contador")!=null) {
					actual=(Integer)session.getAttribute("contador");
				}
				/*actual++;
				session.setAttribute("contador", actual);*/
				session.setAttribute("contador", ++actual);
				
				
				int global=0;
				if(session.getAttribute("contglobal")!=null) {
					global=(Integer)context.getAttribute("contglobal");
				}
				
				context.setAttribute("contglobal", ++global);
				//transferir petición a JSP
				request.getRequestDispatcher("resultado.jsp").forward(request, response);
				
			
				
		
	}


	

}
