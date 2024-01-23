package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibrosService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

@WebServlet("/LibrosTemasController")
public class LibrosTemasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idTema=Integer.parseInt(request.getParameter("idTema"));
		LibrosService service=new LibrosService();
		List<Libro> libros=service.librosTema(idTema);
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		out.println(gson.toJson(libros));
		
	}

}
