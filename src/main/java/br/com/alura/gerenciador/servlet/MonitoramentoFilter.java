package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//@WebFilter(urlPatterns = "/entrada") //igual ao servlet garante que todas as requisi��es do service v�o chegar no filter
public class MonitoramentoFilter implements  Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MonitoramentoFilter");
		long antes=System.currentTimeMillis();
		String acao= request.getParameter("acao");
		chain.doFilter(request, response);
		
		long depois= System.currentTimeMillis();
		System.out.println("Tempo de Execu��o da acao:"+acao+"-->"+(depois-antes));
		
	}

}
