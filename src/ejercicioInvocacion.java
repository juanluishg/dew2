import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ejercicioInvocacion extends HttpServlet {
	void comun(HttpServletRequest request, HttpServletResponse response, String metodo) throws ServletException, IOException {
		String cadena;
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		// recuperar informacion de la sesion e imprimir
		HttpSession sesion = request.getSession(true);
		if (sesion.isNew()) cadena="Es una invocacion nueva";
		else {Date hora=new Date(sesion.getLastAccessedTime());
			cadena="Ultima invocacion fue por "+sesion.getAttribute("metodo").toString() +
					" el " + hora;}

		// guardar metodo para proxima invocacion
		sesion.setAttribute("metodo", metodo);
		out.println(cadena);	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		comun(request, response, "GET");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		comun(request, response, "POST");
	}
}