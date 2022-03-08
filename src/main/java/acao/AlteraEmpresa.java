package acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class AlteraEmpresa implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String nomeEmpresa= request.getParameter("nome");
		String paramDataAbertura= request.getParameter("data");
		System.out.println(paramDataAbertura);
		String id= request.getParameter("id");
		Long i=Long.valueOf(id);
		
		
		Date data=null;
		
		try {
			SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		     data=sdf.parse(paramDataAbertura);
		 
		} catch (ParseException e) {
			
			throw new ServletException(e);
		}
		Banco b= new Banco();
		Empresa emp=b.buscaEmpresaId(i);
	    emp.setDataAbertura(data);
	
		emp.setNome(nomeEmpresa);
		

		
		return "redirect:servletPrincipal?acao=listaEmpresa";
	}
	

}
