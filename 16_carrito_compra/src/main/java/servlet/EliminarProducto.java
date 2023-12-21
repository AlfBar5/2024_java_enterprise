package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//recogo datos del formulario
		//recogemos dato del inputtext
		String nombre=request.getParameter("nombre").toString();
		
		//pedimos HttpSession
		HttpSession session=request.getSession();
		
		//llenamos la lista de productos con la lista de la sesion
		List<Producto> productos = (List<Producto>)session.getAttribute("carrito");
		productos.removeIf(p->p.getNombre().equals(nombre));
		
		//no es necesario hacer un setAttribute de productos, pues la variable productos
		//y el atributo de sesión apuntan a la misma lista. Si la lista se modifica a través
		//de la variable productos, ya queda modificada para la sesión. Aunque no pasa nada por ponerla
		session.setAttribute("carrito", productos);	
		
		//transferimos petición con ArrayList resultados a verlibros.jsp
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
		
	}

}
