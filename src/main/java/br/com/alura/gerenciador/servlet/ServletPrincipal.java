package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acao.AlteraEmpresa;
import acao.ListaEmpresas;
import acao.MostraEmpresa;
import acao.NovaEmpresa;
import acao.RemoveEmpresa;

/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet("/servletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String paramAcao= req.getParameter("acao");
		if(paramAcao.equals("listaEmpresa")){
			ListaEmpresas acao= new ListaEmpresas();
		    acao.executa(req, resp);	
		}
		else if(paramAcao.equals("removeEmpresa")){
			
			RemoveEmpresa acao= new RemoveEmpresa();
			acao.executa(req, resp);
		}
		else if (paramAcao.equals("mostraEmpresa")){
			
			MostraEmpresa acao= new MostraEmpresa();
			acao.executa(req, resp);
		}
		else if(paramAcao.equals("alteraEmpresa")){
			AlteraEmpresa acao= new AlteraEmpresa();
			acao.executa(req, resp);
		}
		else if(paramAcao.equals("novaEmpresa")) {
			NovaEmpresa acao= new NovaEmpresa();
			acao.executa(req, resp);
		}
	}
}
