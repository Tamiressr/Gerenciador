package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao{
	
	public  String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Banco b=new Banco();
		
		List<Empresa>empresas=b.getEmpresas();
		System.out.println(empresas);
				
		request.setAttribute("empresas",empresas);
		
		
		return "forward:listaEmpresas.jsp";
	}

}
