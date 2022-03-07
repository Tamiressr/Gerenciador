package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class novaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class novaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nomeEmpresa= request.getParameter("nome");
		String dataAbertura= request.getParameter("data");
		Empresa empresa= new Empresa();
		empresa.setNome(nomeEmpresa);
		
		try {
			SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
			empresa.setDataAbertura(sdf.parse(dataAbertura));
		} catch (ParseException e) {
			
			
			throw new ServletException(e.getMessage());
		}
		Banco b= new Banco();
		b.adiciona(empresa);
		
		response.sendRedirect("listaEmpresa");

				// RequestDispatcher rd= request.getRequestDispatcher("listaEmpresa");
				 //request.setAttribute("empresa", empresa.getNome());
				// rd.forward(request, response);
	}

}
