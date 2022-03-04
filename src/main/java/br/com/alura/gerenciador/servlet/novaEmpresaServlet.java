package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		PrintWriter out= response.getWriter();
		String nomeEmpresa= request.getParameter("nome");
		Empresa empresa= new Empresa();
		empresa.setNome(nomeEmpresa);
		Banco b= new Banco();
		b.adiciona(empresa);
		out.println("<html><body>Cadastro de empresa"+ nomeEmpresa+"</body></html>");
				
	}

}
