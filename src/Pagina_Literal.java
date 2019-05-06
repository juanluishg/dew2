import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/Pagina_Literal")
public class Pagina_Literal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\n" + 
				"<html lang=\"es-es\">\n" + 
				"<head>\n" + 
				"<meta charset=\"utf-8\" />\n" + 
				"<meta name=\"description\" content=\"Laboratorio 2 de DEW, curso 2018/19\" />\n" + 
				"<meta name=\"author\" content=\"Ramon Garcia\" />\n" + 
				"<meta name=\"revised\" content=\"01/03/2019\" />\n" + 
				"  <title>Imprimir literalmente una pagina HTML</title>\n" + 
				"</head>");
		out.print("<body>\n" + 
				"<p>"+new Date().toString()+" Juan Luis Hernandez Garcia y Juan Carlos Cantos Agudo</p>\n" + 
				"<p>Una tabla para la segunda quincena de Abril de 2019</p>\n" + 
				"<table>\n" + 
				"<tr><td>Lunes</td><td>Martes</td><td>Mi&eacute;rcoles</td><td>Jueves</td><td>Viernes</td><td>S&aacute;bado</td><td>Domingo</td></tr>\n" + 
				"<tr><td>15</td><td>16</td><td>17</td><td>18</td><td>19</td><td>20</td><td>21</td></tr>\n" + 
				"<tr><td>22</td><td>23</td><td>24</td><td>25</td><td>26</td><td>27</td><td>28</td></tr>\n" + 
				"</table>\n" + 
				"\n" + 
				"<p>Una foto del Sol ... (buscada en Google)\n" + 
				"<img src=\"http://www.nasa.gov/images/content/479389main_eitplume.jpg\" alt=\"\" /></p>\n" + 
				"\n" + 
				"<p>Redimensionada a la mitad\n" + 
				"<img src=\"http://www.nasa.gov/images/content/479389main_eitplume.jpg\" width=\"510\" alt=\"\" /></p>\n" + 
				"\n" + 
				"<p>La <a href=\"http://www.aemet.es/es/eltiempo/prediccion/municipios/widget/valencia-id46250\">predicci&oacute;n del tiempo en Valencia</a></p>\n" + 
				"\n" + 
				"<p>En la Agencia Estatal de Meteorolog&iacute;a puedes copiar un fragmento de c&oacute;digo (widget) para integrar la predicci&oacute;n en tu p&aacute;gina\n" + 
				"<script type='text/javascript' src='http://www.aemet.es/es/eltiempo/prediccion/municipios/launchwidget/valencia-id46250?w=g4p01110001ohmffffffw600z190x4f86d9t95b6e9'></script>\n" + 
				"<a target='_blank' style='font-weight: bold;font-size: 1.20em;' href='http://www.aemet.es/es/eltiempo/prediccion/municipios/valencia-id46250'>El Tiempo. Consulte la predicci&oacute;n de la AEMET para Valencia</a></p>\n" + 
				"\n" + 
				"<p>Parte combinada: con una tabla de 2x2 y una imagen en cada celda, donde cada imagen sirve enlace para acceder a la portada de El Pais</p>\n" + 
				"\n" + 
				"<table>\n" + 
				"<tr><td><a href=\"http://www.elpais.com/\"><img src=\"http://casa-jardin.net/wp-content/uploads/2009/02/flores.jpg\" width=\"100\" alt=\"\" /></a></td><td><a href=\"http://www.elpais.com/\"><img src=\"http://casa-jardin.net/wp-content/uploads/2009/02/flores.jpg\" width=\"100\" alt=\"\" /></a></td></tr>\n" + 
				"<tr><td><a href=\"http://www.elpais.com/\"><img src=\"http://casa-jardin.net/wp-content/uploads/2009/02/flores.jpg\" width=\"100\" alt=\"\" /></a></td><td><a href=\"http://www.elpais.com/\"><img src=\"http://casa-jardin.net/wp-content/uploads/2009/02/flores.jpg\" width=\"100\" alt=\"\" /></a></td></tr>\n" + 
				"</table>\n" + 
				"</body>\n" + 
				"</html>\n");
	
	}

}
