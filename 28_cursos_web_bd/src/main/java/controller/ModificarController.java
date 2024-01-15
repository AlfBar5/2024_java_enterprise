package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CursosService;

import java.io.IOException;

@WebServlet("/ModificarController")
public class ModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instanciamos la clase del service para poder acceder a sus metodos
		CursosService service= new CursosService();
				
		////recogo datos del formulario
		////recogemos dato del inputtext
		String nombre=request.getParameter("nombre").toString();
		Integer nuevaduracion=Integer.parseInt(request.getParameter("nuevaduracion"));
				
		service.modificarDuracion(nombre, nuevaduracion);
		
		
	}

}
