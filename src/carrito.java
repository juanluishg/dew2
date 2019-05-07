import java.io.*;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 	
 	/**
 	 * Servlet implementation class carrito
 	 */
 	public class carrito extends HttpServlet {
 		private static final long serialVersionUID = 1L;
 	String preTituloHTML5 = "<!DOCTYPE html>\n<html>\n<head>\n"
			+ "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />";
 	
 		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		    response.setContentType("text/plain");
 		    PrintWriter out = response.getWriter();
 		    HttpSession sesion = request.getSession(false);
 	
 		    // Ha de mostrar la lista de identificadores junto con sus contadores
 		    if (sesion==null) {out.println("No hay identificadores que mostrar");}
 		    else {
 		    	Enumeration<String> lista = sesion.getAttributeNames();
 		    	if (lista==null) {out.println("No hay identificadores que mostrar");}
 		      // El error anterior deber�a ser imposible porque toda sesi�n tiene carrito
 		    	else
 		    	{while (lista.hasMoreElements())
 		    		{String id=(String)lista.nextElement();
 		    		 out.println("El contador de "+id+" vale "+sesion.getAttribute(id));}
 		    	}
 		    }
 		}
 	
 		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		    response.setContentType("text/html");
 		    PrintWriter out = response.getWriter();
 		    String id = request.getParameter("id");
 		    HttpSession sesion = request.getSession(true);
 	
 		    // Ha de actualizar el contador asociado a id
            Integer n = (Integer) sesion.getAttribute(id);
            if (n==null) {n=new Integer(1);}
            else {n=new Integer(n.intValue()+1);}
            sesion.setAttribute(id, n);
 	
 		    out.println(preTituloHTML5 +"<title>Carrito</title></head>");
 		    out.println("<body><h1>Carrito</h1>");
 		    out.println("<p>El contador de "+id+" vale "+n+"</p>");
 		    out.println("</body></html>");
 		}
 	}
