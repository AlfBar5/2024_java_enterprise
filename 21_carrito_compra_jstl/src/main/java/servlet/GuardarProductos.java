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

@WebServlet("/GuardarProductos")
public class GuardarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recogo datos del formulario
		//recogemos dato del inputtext
		String nombre=request.getParameter("nombre").toString();
		double precio=Double.parseDouble(request.getParameter("precio"));
		String categoria=request.getParameter("categoria").toString();
		
		
		
		//pedimos HttpSession
		HttpSession session=request.getSession();
		
		//creo e inicializo la lista vacía
		List<Producto> productos = new ArrayList<>();
		/*
		productos.add(new Producto(nombre,precio,categoria));
		session.setAttribute("carrito", productos);	
		*/
		
		//controlamos que la variable de sesión esté creada
		if(session.getAttribute("carrito")!=null) {
			//el List productos lo hemos vaciado al inicializar la lista vacia
			//pero lo volvemos a llenar con los productos guardados en la variable de sesión
			productos = (List<Producto>)session.getAttribute("carrito");
			//añadimos producto
			productos.add(new Producto(nombre,precio,categoria));
			//setAttribute --almacena un atributo con el nombre especificado en el primer parámetro
			//y cuyo valor se indica en el segundo 
			session.setAttribute("carrito", productos);
			
		}else {
			
			productos.add(new Producto(nombre,precio,categoria));
			session.setAttribute("carrito", productos);
					
		}
		
		
		
		
		
		
		
		//transferir petición a JSP
		request.getRequestDispatcher("index.html").forward(request, response);
		
	}

}
