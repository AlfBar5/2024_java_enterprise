package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;


public class BuscarPorDuracion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instanciamos la clase del service para poder acceder a sus metodos
		CursosService service= new CursosService();
						
		//recogo datos del formulario
		//recogemos dato del inputtext
		//guardamos ArrayList de cursos
		List<Curso> cursos= service.duracionCurso(Integer.parseInt(request.getParameter("duracionMin")),Integer.parseInt(request.getParameter("duracionMax")));
						
		//los datos se los entregamos al cliente, a la vista, sin pasar por el controller
		//ya que no se recarga la página entera, si no solo le pasamos los datos a ayax
		//request.setAttribute("productos", productos);
		PrintWriter out=response.getWriter();
						
		//tipo de respuesta: mime type json
		response.setContentType("application/json");
						
		//Creo una instancia de la librería gson
		Gson gson=new Gson();
		//lo datos que nos da el método y guardamos en la List productos, lo convertimos en json
		out.println(gson.toJson(cursos));

		
	}

}
