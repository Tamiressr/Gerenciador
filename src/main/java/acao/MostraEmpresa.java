package acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresa implements Acao{


	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id= request.getParameter("id");
		Long i=Long.valueOf(id);
		Banco b=new Banco();
		Empresa e=b.buscaEmpresaId(i);
		 request.setAttribute("empresa", e);
		 
		 RequestDispatcher rd=request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		 rd.forward(request, response);
	}

}
