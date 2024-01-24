package controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.interfaces.ClientesService;

import java.io.IOException;

import dtos.ClienteDto;

@WebServlet("/AltaController")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ClientesService clientesService;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		clientesService.altaCliente(new ClienteDto(
				request.getParameter("usuario"),
				request.getParameter("password"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("telefono"))
				));
		
		
	}

}
