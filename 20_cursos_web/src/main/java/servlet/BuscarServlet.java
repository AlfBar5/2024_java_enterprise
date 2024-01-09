package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/BuscarServlet")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instanciamos la clase del service para poder acceder a sus metodos
		CursosService service= new CursosService();
		
		//recogo datos del formulario
		//recogemos dato del inputtext
		//guardamos ArrayList de cursos
		ArrayList<Curso> cursos= service.preciosCursoMax(Double.parseDouble(request.getParameter("preciomax")));
		
		//RequestDispatcher dispatcher;
		//GUARDAMOS LOS CURSOS EN UN ATRIBUTO DE PETICIÓN (y lo mandamos a la página de destino)
		request.setAttribute("cursos", cursos);
					
		//transferimos petición con ArrayList resultados a verlibros.jsp
		request.getRequestDispatcher("cursos.jsp").forward(request, response);
		
	}

}
