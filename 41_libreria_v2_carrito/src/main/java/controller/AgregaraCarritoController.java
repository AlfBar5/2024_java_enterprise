package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Libro;
import service.LibrosService;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

@WebServlet("/AgregaraCarritoController")
public class AgregaraCarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
				//Agregamos libro a sesión del carrito
							
				//recogemos dato
				int nisbn=Integer.parseInt(request.getParameter("isbn"));
				
				HttpSession session=request.getSession();
								
				LibrosService service = new LibrosService();
				
				//creo e inicializo la lista vacía
				List<Libro> carrito = new ArrayList<>();
												
				//controlamos que la variable de sesión esté creada
				if(session.getAttribute("carrito")!=null) {
					//el List productos lo hemos vaciado al inicializar la lista vacia
					//pero lo volvemos a llenar con los productos guardados en la variable de sesión
					//Creamos la variable de sesión la primera vez
					carrito = (List<Libro>)session.getAttribute("carrito");
					
					
				}					
				
				//añadimos producto							
				carrito.add(service.getLibro(nisbn));
				session.setAttribute("carrito", carrito);
				
				//envía como respuesta un JSON con los datos del carrito
				Gson gson=new Gson();
				PrintWriter out=response.getWriter();
				response.setContentType("application/json");
				out.println(gson.toJson(carrito));
				
	

		
		
		
	}

}
