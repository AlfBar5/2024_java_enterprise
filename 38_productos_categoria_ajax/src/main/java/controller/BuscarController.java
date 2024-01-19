package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

@WebServlet("/BuscarController")
public class BuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosService productosService=new ProductosService();
		List<Producto> productos=productosService.buscarPorCategoria(request.getParameter("categoria"));
		
		//los datos se los entregamos al cliente, a la vista, sin pasar por el controller
		//ya que no se recarga la página entera, si no solo le pasamos los datos a ayax
		//request.setAttribute("productos", productos);
		PrintWriter out=response.getWriter();
		
		//tipo de respuesta: mime type json
		response.setContentType("application/json");
		
		//Creo una instancia de la librería gson
		Gson gson=new Gson();
		//lo datos que nos da el método y guardamos en la List productos, lo convertimos en json
		out.println(gson.toJson(productos));
		
		
	}

}
