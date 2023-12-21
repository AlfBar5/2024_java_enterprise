package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.BuscadorService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BuscadorLibros")
public class BuscadorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//En servlet nos comunicamos con la capa service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//recogemos dato del inputtext
		String tematica=request.getParameter("buscador").toString();
		
		//creo lista de datos tipo arraylist
		List<Resultado> resultados = new ArrayList<>();
		
		//instanciamos la clase para poder acceder a sus metodos
		BuscadorService service=new BuscadorService();
		
		//acceder al método
		resultados = service.devolresultados(tematica);
		
		
		//RequestDispatcher dispatcher;
		//GUARDAMOS LA FICHA EN UN ATRIBUTO DE PETICIÓN (y lo mandamos a la página de destino)
		request.setAttribute("result", resultados);
	
		//transferimos petición con ArrayList resultados a verlibros.jsp
		request.getRequestDispatcher("verlibros.jsp").forward(request, response);
		
		
		/*
		BuscadorService buscadorService=new BuscadorService();
		List<Resultado> resultados=buscadorService.devolresultados(request.getParameter("tematica"));
		//guardamos resultados en atributo de petición
		request.setAttribute("result", resultados);
		//transferir petición a la JSP
		request.getRequestDispatcher("verlibros.jsp").forward(request, response);
		*/
		
		
	}

}
