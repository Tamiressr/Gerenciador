package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoveEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		String id= request.getParameter("id");
		Long i=Long.valueOf(id);
		Banco b=new Banco();
		b.remove(i);
		
			return "redirect:servletPrincipal?acao=ListaEmpresas";
		
	}
}
