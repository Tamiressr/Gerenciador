package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listaEmpresaServlet
 */
@WebServlet("/listaEmpresa")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Banco b=new Banco();
		
		List<Empresa>empresas=b.getEmpresas();
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<ul>");
		for(Empresa e:empresas) {
			
			out.println("<li>"+e.getNome()+"</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

	
}
