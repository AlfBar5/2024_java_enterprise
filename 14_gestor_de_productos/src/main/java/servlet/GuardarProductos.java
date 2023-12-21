package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GuardarProductos")
public class GuardarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recogo datos del formulario
		//recogemos dato del inputtext
		String nombre=request.getParameter("nombre").toString();
		double precio=Double.parseDouble(request.getParameter("precio"));
		String categoria=request.getParameter("categoria").toString();
		
		
		//instanciamos la clase del service para poder acceder a sus metodos
		ProductosService service = new ProductosService();
		//guardar libros
		service.altaProductos(nombre, precio, categoria);
		
		
		////Devuelvo todos los productos al index
		//creo lista de datos tipo arraylist
		List<Producto> resultados = new ArrayList<>();
				
		//acceder al método todos los productos
		resultados = service.todosProductos();
				
				
		//RequestDispatcher dispatcher;
		//GUARDAMOS LA FICHA EN UN ATRIBUTO DE PETICIÓN (y lo mandamos a la página de destino)
		request.setAttribute("result", resultados);
			
		//transferimos petición con ArrayList resultados a verlibros.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
	}

}
