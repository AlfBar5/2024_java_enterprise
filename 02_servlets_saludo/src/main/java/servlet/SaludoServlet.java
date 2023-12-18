package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//la clase hereda HttpServlet 
public class SaludoServlet extends HttpServlet {
	//esta constante la pone eclipse, pero no la vamos a usar para nada
	private static final long serialVersionUID = 1L;

	
	//sobreescribimos el método service
	//hay que darle dos parámetros: un objeto request, un response
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//A este método lo llama el servidor de aplicaciones 
		//y le manda estos dos objetos interfaces (polimorfismo) que tienen sus métodos
		
		//el objeto response es el que se usa para manejar la respuesta del servidor. 
		//Le dice al cliente que le va a enviar --->html
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body><center>");
		for(int i=1;i<=6;i++) {
			out.println("<h"+i+">Primer servlet</h"+i+">");
		}
		out.println("</center></body></html>");
		out.close(); 

		//en este ejemplo no usamos todavía el request, ya que no hay nada en la petición
		//que me sirva para algo
		
	}

}
