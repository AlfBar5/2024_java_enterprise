package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Construir la Tabla de Multiplicar de los números del 1 al 10
 */
public class TablaMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//el objeto response es el que se usa para manejar la respuesta del servidor. 
		//Le dice al cliente que le va a enviar --->html
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
				
		out.println("<html><body><center>");
		
		
		for(int n=1;n<=9;n++) {
		
			out.println("<br><table style=' border: 1px solid black; border-collapse: collapse; padding:5px;'>\r\n"
					+ "  <tr>\r\n"
					+ "    <th style='border: 1px solid black;padding:5px;' >Tabla del: "+n+"</th>\r\n"
					+ "    <th  style='border: 1px solid black;padding:5px;' >Resultado</th>\r\n"
					+ "  </tr>");
			
			for(int i=1;i<=9;i++) {
				out.println("<tr>\r\n"
						+ "<td style='border: 1px solid black;padding:5px;' >"+i+"x"+n+"</td>\r\n"
						+ "<td style='border: 1px solid black;padding:5px;'>"+i*n+"</td>\r\n"
						+ "</tr>\r\n"
						);
			}
		
		
		
		out.println("</table>");
		
		}
		
		out.println("</center></body></html>");
		out.close(); 
		
		
	}

}
