import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class maxiteclado extends HttpServlet{
	int contador = 0;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession sesion = req.getSession(true);
		PrintWriter out = resp.getWriter();
		out.println("\n" + 
				"<!DOCTYPE html>\n" + 
				"<html lang='es-es'>\n" + 
				"<head>\n" + 
				"  <meta name='description' content='Laboratorio 2 de DEW, curso 2018/19' />\n" + 
				"  <meta name='author' content='Ramon Garcia' />\n" + 
				"  <meta name='revised' content='18/04/2019' />\n" + 
				"  <link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Montserrat' />\n" + 
				"  <link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Fondamento' />\n" + 
				"  <link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Lobster' />\n" + 
				"  <style>\n" + 
				"   .banda {clear:left; background-color:bisque; text-align:center;}\n" + 
				"   .mini  {font-size:0.8em;}\n" + 
				"   .medio {font-size:1.2em;}\n" + 
				"   .maxi  {font-size:1.6em;}\n" + 
				"   .r    {color:#FF0000;}\n" + 
				"   .g    {color:#00FF00;}\n" + 
				"   .b    {color:#0000FF;}\n" + 
				"   .rg   {color:#FFFF00;}\n" + 
				"   .rb   {color:#FF00FF;}\n" + 
				"   .gb   {color:#00FFFF;}\n" + 
				"   .rgb  {color:#FFFFFF;}\n" + 
				"   .f1  {font-family:'Montserrat', cursive;}\n" + 
				"   .f2  {font-family:'Fondamento', cursive;}\n" + 
				"   .f3  {font-family:'Lobster', cursive;}\n" + 
				"  </style>\n" + 
				"  <title>Teclado avanzado</title>\n" + 
				"</head>\n" + 
				"  <body style='background-color:silver;'>\n" + 
				"\n" + 
				"<div class='banda'><h1>Teclado avanzado</h1></div>\n" + 
				"\n" + 
				"<form action='maxiteclado' method='post'>\n" + 
				"\n" + 
				"<div style='float:left;'>\n" + 
				"  <table style='border:none;'>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='1' /></td><td><input type='submit' name='tecla' value='2' /></td><td><input type='submit' name='tecla' value='3' /></td><td><input type='submit' name='tecla' value='4' /></td><td><input type='submit' name='tecla' value='5' /></td><td><input type='submit' name='tecla' value='6' /></td><td><input type='submit' name='tecla' value='7' /></td><td><input type='submit' name='tecla' value='8' /></td><td><input type='submit' name='tecla' value='9' /></td><td><input type='submit' name='tecla' value='0' /></td><td><input type='submit' name='tecla' value='/' /></td></tr>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='q' /></td><td><input type='submit' name='tecla' value='w' /></td><td><input type='submit' name='tecla' value='e' /></td><td><input type='submit' name='tecla' value='r' /></td><td><input type='submit' name='tecla' value='t' /></td><td><input type='submit' name='tecla' value='y' /></td><td><input type='submit' name='tecla' value='u' /></td><td><input type='submit' name='tecla' value='i' /></td><td><input type='submit' name='tecla' value='o' /></td><td><input type='submit' name='tecla' value='p' /></td><td><input type='submit' name='tecla' value='*' /></td></tr>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='a' /></td><td><input type='submit' name='tecla' value='s' /></td><td><input type='submit' name='tecla' value='d' /></td><td><input type='submit' name='tecla' value='f' /></td><td><input type='submit' name='tecla' value='g' /></td><td><input type='submit' name='tecla' value='h' /></td><td><input type='submit' name='tecla' value='j' /></td><td><input type='submit' name='tecla' value='k' /></td><td><input type='submit' name='tecla' value='l' /></td><td><input type='submit' name='tecla' value='&ntilde;' /></td></tr>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='z' /></td><td><input type='submit' name='tecla' value='x' /></td><td><input type='submit' name='tecla' value='c' /></td><td><input type='submit' name='tecla' value='v' /></td><td><input type='submit' name='tecla' value='b' /></td><td><input type='submit' name='tecla' value='n' /></td><td><input type='submit' name='tecla' value='m' /></td><td><input type='submit' name='tecla' value=',' /></td><td><input type='submit' name='tecla' value='.' /></td><td><input type='submit' name='tecla' value='-' /></td></tr>\n" + 
				"  </table>\n" + 
				"  <input type='submit' name='tecla' value='Espacio' />\n" + 
				"</div>\n" + 
				"<div style='float:right;'>\n" + 
				"  <input type='checkbox' name='color' value='r' /><span class='r'>r</span>\n" + 
				"  <input type='checkbox' name='color' value='g' /><span class='g'>g</span>\n" + 
				"  <input type='checkbox' name='color' value='b' /><span class='b'>b</span>\n" + 
				"  <p>\n" + 
				"    <button type='submit' name='font' value='f1' ><span class='f1'>Montserrat</span></button>\n" + 
				"    <button type='submit' name='font' value='f2' ><span class='f2'>Fondamento</span></button>\n" + 
				"    <button type='submit' name='font' value='f3' ><span class='f3'>Lobster</span></button>\n" + 
				"  </p>\n" + 
				"\n" + 
				"  <p>\n" + 
				"    <button type='submit' name='size' value='mini' ><span class='mini'>mini</span></button>\n" + 
				"    <button type='submit' name='size' value='medio' ><span class='medio'>medio</span></button>\n" + 
				"    <button type='submit' name='size' value='maxi' ><span class='maxi'>maxi</span></button>\n" + 
				"  </p>\n" + 
				"</div>\n" + 
				"</form>\n" + 
				"<div class='banda'>\n" + 
				"  <p>Comenzamos ...</p>\n" + 
				"  <p>Ve pulsando ...</p></div>\n" + 
				"</body>\n" + 
				"</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession sesion = req.getSession(false);
		String estilo = "";
		if(sesion==null) doGet(req,resp);
		else {
		    String tecla = req.getParameter("tecla");
		    if(tecla==null) {
		    	tecla="";
		    	contador--;
		    }
		    
		    String color ="";
		    String colores[] = req.getParameterValues("color");
		    String checkedR = "";
		    String checkedG = "";
		    String checkedB = "";
		    if(colores==null) {
		    	String colorAnt = (String)sesion.getAttribute("color");
		    	color = "";
	    	}else {
	    		for(String colorArray: colores) {
	    			color += colorArray;
	    			if(colorArray.equals("r")) checkedR = "checked='checked'";
	    			if(colorArray.equals("g")) checkedG = "checked='checked'";
	    			if(colorArray.equals("b")) checkedB = "checked='checked'";		
	    		}
	    		sesion.setAttribute("color", color);
	    	}
		    String tamanyo = req.getParameter("size");
		    if(tamanyo==null) {
		    	tamanyo = (String)sesion.getAttribute("tamanyo");
		    }else {
		    	sesion.setAttribute("tamanyo", tamanyo);
		    }
		    
		    String fuente = req.getParameter("font");
		    if(fuente==null) {
		    	fuente = (String)sesion.getAttribute("fuente");
		    }else {
		    	sesion.setAttribute("fuente", fuente);
		    }
	    
		    estilo = color + " " + tamanyo + " " + fuente;
		    
		    contador++;
		    
		out.println("<!DOCTYPE html>\n" + 
				"<html lang='es-es'>\n" + 
				"<head>\n" + 
				"  <meta name='description' content='Laboratorio 2 de DEW, curso 2018/19' />\n" + 
				"  <meta name='author' content='JuanLu && Juankk' />\n" + 
				"  <meta name='revised' content='07/05/2019' />\n" + 
				"  <link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Montserrat' />\n" + 
				"  <link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Fondamento' />\n" + 
				"  <link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Lobster' />\n" + 
				"  <style>\n" + 
				"   .banda {clear:left; background-color:bisque; text-align:center;}\n" + 
				"   .mini  {font-size:0.8em;}\n" + 
				"   .medio {font-size:1.2em;}\n" + 
				"   .maxi  {font-size:1.6em;}\n" + 
				"   .r    {color:#FF0000;}\n" + 
				"   .g    {color:#00FF00;}\n" + 
				"   .b    {color:#0000FF;}\n" + 
				"   .rg   {color:#FFFF00;}\n" + 
				"   .rb   {color:#FF00FF;}\n" + 
				"   .gb   {color:#00FFFF;}\n" + 
				"   .rgb  {color:#FFFFFF;}\n" + 
				"   .f1  {font-family:'Montserrat', cursive;}\n" + 
				"   .f2  {font-family:'Fondamento', cursive;}\n" + 
				"   .f3  {font-family:'Lobster', cursive;}\n" + 
				"  </style>\n" + 
				"  <title>Teclado avanzado</title>\n" + 
				"</head>\n" + 
				"  <body style='background-color:silver;'>\n" + 
				"\n" + 
				"<div class='banda "+estilo+"'><h1>Teclado avanzado</h1></div>\n" + 
				"\n" + 
				"<form action='maxiteclado' method='post'>\n" + 
				"\n" + 
				"<div style='float:left;'>\n" + 
				"  <table style='border:none;'>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='1' /></td><td><input type='submit' name='tecla' value='2' /></td><td><input type='submit' name='tecla' value='3' /></td><td><input type='submit' name='tecla' value='4' /></td><td><input type='submit' name='tecla' value='5' /></td><td><input type='submit' name='tecla' value='6' /></td><td><input type='submit' name='tecla' value='7' /></td><td><input type='submit' name='tecla' value='8' /></td><td><input type='submit' name='tecla' value='9' /></td><td><input type='submit' name='tecla' value='0' /></td><td><input type='submit' name='tecla' value='/' /></td></tr>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='q' /></td><td><input type='submit' name='tecla' value='w' /></td><td><input type='submit' name='tecla' value='e' /></td><td><input type='submit' name='tecla' value='r' /></td><td><input type='submit' name='tecla' value='t' /></td><td><input type='submit' name='tecla' value='y' /></td><td><input type='submit' name='tecla' value='u' /></td><td><input type='submit' name='tecla' value='i' /></td><td><input type='submit' name='tecla' value='o' /></td><td><input type='submit' name='tecla' value='p' /></td><td><input type='submit' name='tecla' value='*' /></td></tr>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='a' /></td><td><input type='submit' name='tecla' value='s' /></td><td><input type='submit' name='tecla' value='d' /></td><td><input type='submit' name='tecla' value='f' /></td><td><input type='submit' name='tecla' value='g' /></td><td><input type='submit' name='tecla' value='h' /></td><td><input type='submit' name='tecla' value='j' /></td><td><input type='submit' name='tecla' value='k' /></td><td><input type='submit' name='tecla' value='l' /></td><td><input type='submit' name='tecla' value='&ntilde;' /></td></tr>\n" + 
				"    <tr><td><input type='submit' name='tecla' value='z' /></td><td><input type='submit' name='tecla' value='x' /></td><td><input type='submit' name='tecla' value='c' /></td><td><input type='submit' name='tecla' value='v' /></td><td><input type='submit' name='tecla' value='b' /></td><td><input type='submit' name='tecla' value='n' /></td><td><input type='submit' name='tecla' value='m' /></td><td><input type='submit' name='tecla' value=',' /></td><td><input type='submit' name='tecla' value='.' /></td><td><input type='submit' name='tecla' value='-' /></td></tr>\n" + 
				"  </table>\n" + 
				"  <input type='submit' name='tecla' value='Espacio' />\n" + 
				"</div>\n" + 
				"<div style='float:right;'>\n" + 
				"  <input type='checkbox' name='color' value='r' "+checkedR+"/><span class='r'>r</span>\n" + 
				"  <input type='checkbox' name='color' value='g' "+checkedG+"/><span class='g'>g</span>\n" + 
				"  <input type='checkbox' name='color' value='b' "+checkedB+"/><span class='b'>b</span>\n" + 
				"  <p>\n" + 
				"    <button type='submit' name='font' value='f1' ><span class='f1'>Montserrat</span></button>\n" + 
				"    <button type='submit' name='font' value='f2' ><span class='f2'>Fondamento</span></button>\n" + 
				"    <button type='submit' name='font' value='f3' ><span class='f3'>Lobster</span></button>\n" + 
				"  </p>\n" + 
				"\n" + 
				"  <p>\n" + 
				"    <button type='submit' name='size' value='mini' ><span class='mini'>mini</span></button>\n" + 
				"    <button type='submit' name='size' value='medio' ><span class='medio'>medio</span></button>\n" + 
				"    <button type='submit' name='size' value='maxi' ><span class='maxi'>maxi</span></button>\n" + 
				"  </p>\n" + 
				"</div>\n" + 
				"</form>\n" + 
				"<div class='banda'>\n" + 
				"  <p>&Uacute;ltima tecla pulsada: <span class='"+estilo+"' >"+tecla+"</span></p>\n" + 
				"  <p>Recuento total: <span class='"+estilo+"' >"+contador+"</span></p>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"</html>\n");
		}
	}

	@Override
	public void destroy() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(getServletContext().getInitParameter("fichero"));
			pw = new PrintWriter(fichero);
			pw.print(contador);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}finally {
			try {
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void init() throws ServletException {
		File fichero = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fichero = new File(getServletContext().getInitParameter("fichero"));
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			
			String num = br.readLine();
			contador = Integer.parseInt(num);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
