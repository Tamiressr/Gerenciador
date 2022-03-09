package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class ControladorFilter
 */
//@WebFilter("/entrada")
public class ControladorFilter extends HttpFilter implements Filter {
       
  
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
	
		
		System.out.println("ControladorFilter");
		HttpServletRequest req= (HttpServletRequest)servletRequest;
		HttpServletResponse resp=(HttpServletResponse)servletResponse;
		
		String paramAcao= req.getParameter("acao");
		
		String nomeDaClasse= "br.com.alura.gerenciador.acao."+paramAcao;
		
		String nome;
		try {
			Class classe= Class.forName(nomeDaClasse);
			
			Acao obj=(Acao)classe.newInstance(); //API de Reflection  + Padrão de projeto Command aplicado para receber um parametro na req e delegar pra o caminho específico
			nome = obj.executa(req,resp);
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
		
		//não tem o chain pq é o ultimo filtro 
	}



}
