package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa= request.getParameter("nome");
		String dataAbertura= request.getParameter("data");
		String id= request.getParameter("id");
		Long i=Long.valueOf(id);
		
		Date data=null;

		try {
			SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		data=sdf.parse(dataAbertura);
		} catch (ParseException e) {
			
			
			throw new ServletException(e.getMessage());
		}
		Banco b= new Banco();
		Empresa e=b.buscaEmpresaId(i);
		e.setNome(nomeEmpresa);
		e.setDataAbertura(data);
		response.sendRedirect("listaEmpresa");
		
	}

}
