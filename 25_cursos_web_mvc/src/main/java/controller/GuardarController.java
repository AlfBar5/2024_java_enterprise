package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CursosService;

import java.io.IOException;

@WebServlet("/GuardarController")
public class GuardarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instanciamos la clase del service para poder acceder a sus metodos
		CursosService service= new CursosService();
		
		////recogo datos del formulario
		////recogemos dato del inputtext
		String nombre=request.getParameter("nombre").toString();
		Integer duracion=Integer.parseInt(request.getParameter("duracion"));
		double precio=Double.parseDouble(request.getParameter("precio"));
		service.nuevo(nombre, duracion, precio);
		
		////acceder al método todos los cursos
		//resultados = service.todosCursos();
		
		////RequestDispatcher dispatcher;
		////GUARDAMOS LA FICHA EN UN ATRIBUTO DE PETICIÓN (y lo mandamos a la página de destino)
		//request.setAttribute("result", resultados);
					
		////transferimos petición con ArrayList resultados a verlibros.jsp
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		//request.getRequestDispatcher("nuevo.html").forward(request, response);
		
	}

}
