package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao{
	
	public  String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	
		HttpSession sessao= request.getSession();
		if(sessao.getAttribute("usuarioLogado")==null) {
			return "redirect:entrada?acao=LoginForm";
		}
		Banco b=new Banco();
		List<Empresa>empresas=b.getEmpresas();
				
		request.setAttribute("empresas",empresas);
		
		
		return "forward:listaEmpresas.jsp";
	}

}
