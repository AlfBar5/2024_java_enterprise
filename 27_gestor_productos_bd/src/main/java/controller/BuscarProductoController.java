package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

import java.io.IOException;
import java.util.List;

@WebServlet("/BuscarProductoController")
public class BuscarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductosService productosService=new ProductosService();
		//recogo parámetro y lo convierto a int
		Integer idproduct = Integer.parseInt(request.getParameter("idproducto"));
		//llamo a método buscarProducto y la paso idproduct
		Producto product=productosService.buscarProducto(idproduct);
		//para que lo pueda ver la página jsp, lo guardamos en un atributo
		request.setAttribute("producto", product);
		
	}

}
