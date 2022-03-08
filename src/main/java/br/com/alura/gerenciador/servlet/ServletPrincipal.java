package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acao.Acao;

/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet("/servletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String paramAcao= req.getParameter("acao");
		
		
		String nomeDaClasse= "br.com.alura.gerenciador.acao."+paramAcao;
		
		String nome="";
		try {
			Class classe= Class.forName(nomeDaClasse);
			Object obj=classe.newInstance(); //reflection  + Padrão de projeto Command aplicado para receber um parametro na req e delegar pra o caminho específico
			Acao acao=(Acao)obj;
			nome = acao.executa(req,resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		
		String []tipoEEndereco=nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd= req.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(req, resp);
		}
		else {
			resp.sendRedirect(tipoEEndereco[1]);
		}
	}
}
