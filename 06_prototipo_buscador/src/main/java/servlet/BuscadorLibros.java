package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.BuscadorService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class BuscadorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//En servlet nos comunicamos con la capa service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recogemos dato del inputtext
		String tematica=request.getParameter("buscador").toString();
		
		//creo lista de datos tipo arraylist
		ArrayList<Resultado> resultados = new ArrayList<>();
		
		//instanciamos la clase para poder acceder a sus metodos
		BuscadorService service=new BuscadorService();
		
		//acceder al método
		resultados = service.devolresultados(tematica);
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
				
		out.println("<html>"
				+ " <head>	<meta charset='ISO-8859-1'>	<title>Buscador por temática</title>"
				+ "<link href='https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css' rel='stylesheet'>"
				+ "</head>"
				+ "<body class=\"bg-light\"><center><div class=\"row\">\r\n"
				+ "<div class=\"col-md-3 order-md-2 mb-4\"> </div>"
				+ "<div class=\"col-md-6 order-md-2 mb-4\">");
		
		
		out.println("<br><table class='table table-dark'>\r\n"
				+ "  <tr>\r\n"
				+ "    <th style='border: 1px solid black;padding:5px;text-align: center;' >Mostrando: "+tematica+"</th>\r\n"
				+ "    <th  style='border: 1px solid black;padding:5px;text-align: center;' >Descripción</th>\r\n"
				+ "    <th  style='border: 1px solid black;padding:5px;text-align: center;' >URL</th>\r\n"
				+ "  </tr>");
		
		
		for(Resultado s:resultados) {
			out.println("<tr>\r\n"
					+ "<td style='border: 1px solid black;padding:5px;text-align: center;' >"+s.getTematica()+"</td>\r\n"
					+ "<td style='border: 1px solid black;padding:5px;text-align: center;'>"+s.getDescripcion()+"</td>\r\n"
					+ "<td style='border: 1px solid black;padding:5px;text-align: center;'><a href='"+s.getUrl()+"' target=\"_blank\">"+s.getUrl()+"</a></td>\r\n"
					+ "</tr>\r\n"
					);
		}
	
	
	
	out.println("</table><br><br>"
			+ "<a href='./buscadorlibros.html'>VOLVER</a>"
			+ "</div>\r\n"
			+ "\r\n"
			+ "<div class=\"col-md-3 order-md-2 mb-4\"></div>");
	
	out.println("");
	
	out.println("</center></body></html>");
	out.close();
		
		
		
		
	}

}
