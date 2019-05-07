import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class miniteclado extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesion = req.getSession(true);
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>\n" + 
				"<html lang=\"es-es\">\n" + 
				"<head>\n" + 
				"  <meta name='description' content='Laboratorio 2 de DEW, curso 2018/19' />\n" + 
				"  <meta name='author' content='Ramon Garcia' />\n" + 
				"  <meta name='revised' content='18/04/2019' />\n" + 
				"<title>Modesto teclado con sesiones</title>\n" + 
				"</head>\n" + 
				"<body><h1>Modesto teclado con sesiones</h1>\n" + 
				"\n" + 
				"<p>Comenzamos ...</p>\n" + 
				"\n" + 
				"<p>Ve pulsando ...</p>\n" + 
				"<form action=\"miniteclado\" method=\"post\">\n" + 
				"\n" + 
				"<table style='border:none;'>\n" + 
				"<tr><td><input type=\"submit\" name=\"tecla\" value=\"1\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"2\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"3\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"4\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"5\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"6\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"7\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"8\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"9\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"0\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"/\" /></td></tr>\n" + 
				"<tr><td><input type=\"submit\" name=\"tecla\" value=\"q\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"w\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"e\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"r\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"t\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"y\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"u\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"i\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"o\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"p\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"*\" /></td></tr>\n" + 
				"<tr><td><input type=\"submit\" name=\"tecla\" value=\"a\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"s\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"d\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"f\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"g\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"h\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"j\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"k\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"l\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"&ntilde;\" /></td></tr>\n" + 
				"<tr><td><input type=\"submit\" name=\"tecla\" value=\"z\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"x\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"c\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"v\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"b\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"n\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"m\" /></td><td><input type=\"submit\" name=\"tecla\" value=\",\" /></td><td><input type=\"submit\" name=\"tecla\" value=\".\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"-\" /></td></tr>\n" + 
				"</table>\n" + 
				"\n" + 
				"<input type=\"submit\" name=\"tecla\" value=\"Retroceso\" />\n" + 
				"<input type=\"submit\" name=\"tecla\" value=\"Espacio\" />\n" + 
				"</form>\n" + 
				"</body></html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession sesion = req.getSession(false);
		if(sesion==null) doGet(req,resp);
		else {
		    String tecla = req.getParameter("tecla");
			String total = (String) sesion.getAttribute("tecla");
			if(total==null)total="";
			
			if(tecla.equals("Espacio")) {
				total = total +" ";
			}
			
			else if(tecla.equals("Retroceso") && total.length()>0) {
				total = total.substring(0,total.length()-1);
			}
			else if(tecla.equals("Retroceso") && total.length()<=0) {
				total = "";
			}
			else {
				total = total+tecla;				
			}
			
			sesion.setAttribute("tecla",total);
			
			out.println("<!DOCTYPE html>\n" + 
					"<html lang=\"es-es\">\n" + 
					"<head>\n" + 
					"  <meta name='description' content='Laboratorio 2 de DEW, curso 2018/19' />\n" + 
					"  <meta name='author' content='Ramon Garcia' />\n" + 
					"  <meta name='revised' content='18/04/2019' />\n" + 
					"<title>Modesto teclado con sesiones</title>\n" + 
					"</head>\n" + 
					"<body><h1>Modesto teclado con sesiones</h1>\n" + 
					"\n" + 
					"<p>&Uacute;ltima tecla pulsada: <strong>"+ tecla +"</strong></p>\n" + 
					"\n" + 
					"<p>Total escrito: <strong>'"+total+"'</strong></p>\n" + 
					"<form action=\"miniteclado\" method=\"post\">\n" + 
					"\n" + 
					"<table style='border:none;'>\n" + 
					"<tr><td><input type=\"submit\" name=\"tecla\" value=\"1\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"2\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"3\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"4\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"5\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"6\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"7\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"8\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"9\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"0\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"/\" /></td></tr>\n" + 
					"<tr><td><input type=\"submit\" name=\"tecla\" value=\"q\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"w\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"e\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"r\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"t\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"y\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"u\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"i\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"o\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"p\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"*\" /></td></tr>\n" + 
					"<tr><td><input type=\"submit\" name=\"tecla\" value=\"a\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"s\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"d\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"f\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"g\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"h\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"j\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"k\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"l\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"&ntilde;\" /></td></tr>\n" + 
					"<tr><td><input type=\"submit\" name=\"tecla\" value=\"z\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"x\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"c\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"v\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"b\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"n\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"m\" /></td><td><input type=\"submit\" name=\"tecla\" value=\",\" /></td><td><input type=\"submit\" name=\"tecla\" value=\".\" /></td><td><input type=\"submit\" name=\"tecla\" value=\"-\" /></td></tr>\n" + 
					"</table>\n" + 
					"\n" + 
					"<input type=\"submit\" name=\"tecla\" value=\"Retroceso\" />\n" + 
					"<input type=\"submit\" name=\"tecla\" value=\"Espacio\" />\n" + 
					"</form>\n" + 
					"</body></html>");
			
		}
	}

}
