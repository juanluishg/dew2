import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String preTituloHTML5 = "<!DOCTYPE html>\n<html>\n<head>\n"
				+ "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />";
		response.setContentType("text/html");
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		out.println(preTituloHTML5);
		out.println("<title>Hola Mundo</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hola Mundo!</h1>");
		out.println("<h2>"+id+"</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
