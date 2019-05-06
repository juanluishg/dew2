import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tratar_opciones")
public class Opciones extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		PrintWriter out = response.getWriter();
		try {
			int num = Integer.parseInt(opcion);
			switch (num) {
			case 1:
				response.sendRedirect("/Pagina_Literal");
				break;

			case 2:
				response.sendRedirect("http://www.w3c.es/");
				break;
				
			default:
				break;
			}
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
