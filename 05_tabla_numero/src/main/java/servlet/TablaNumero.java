package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TablaNumero
 */
public class TablaNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer numero=Integer.parseInt(request.getParameter("numero"));
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
				
		out.println("<html>"
				+ " <head>	<meta charset='ISO-8859-1'>	<title>Insert title here</title>"
				+ "<link href='https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css' rel='stylesheet'>"
				+ "</head>"
				+ "<body><center><div class=\"row\">\r\n"
				+ "<div class=\"col-md-4 order-md-2 mb-4\"> </div>"
				+ "<div class=\"col-md-4 order-md-2 mb-4\">");
		
		
		out.println("<br><table class='table table-dark'>\r\n"
				+ "  <tr>\r\n"
				+ "    <th style='border: 1px solid black;padding:5px;text-align: center;' >Tabla del: "+numero+"</th>\r\n"
				+ "    <th  style='border: 1px solid black;padding:5px;text-align: center;' >Resultado</th>\r\n"
				+ "  </tr>");
		
		
		for(int i=1;i<=9;i++) {
			out.println("<tr>\r\n"
					+ "<td style='border: 1px solid black;padding:5px;text-align: center;' >"+i+"x"+numero+"</td>\r\n"
					+ "<td style='border: 1px solid black;padding:5px;text-align: center;'>"+i*numero+"</td>\r\n"
					+ "</tr>\r\n"
					);
		}
	
	
	
	out.println("</table><br><br>"
			+ "<a href='./numero.html'>VOLVER</a>"
			+ "</div>\r\n"
			+ "\r\n"
			+ "<div class=\"col-md-4 order-md-2 mb-4\"></div>");
	
	out.println("");
	
	out.println("</center></body></html>");
	out.close();
		
		
	}

}
