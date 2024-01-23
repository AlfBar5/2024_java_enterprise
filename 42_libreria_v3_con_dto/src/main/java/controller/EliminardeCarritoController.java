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

import dtos.LibroDto;

@WebServlet("/EliminardeCarritoController")
public class EliminardeCarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recogemos posición del dato. También se podría hacer por isbn
		int pos=Integer.parseInt(request.getParameter("pos"));
		
		//pedimos HttpSession
		HttpSession session=request.getSession();
		
		LibrosService service = new LibrosService();
		
		//llenamos la lista de libros con la lista de la sesion
		List<LibroDto> carrito=new ArrayList<>();
		if(session.getAttribute("carrito")!=null) {
				carrito=(List<LibroDto>)session.getAttribute("carrito");
				carrito.remove(pos);
		}
		
		session.setAttribute("carrito", carrito);
		//envía como respuesta un JSON con los datos del carrito
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		out.println(gson.toJson(carrito));
		
	}

}
