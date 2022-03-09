package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login=request.getParameter("login");
		String senha= request.getParameter("senha");
		Banco b= new Banco();
		Usuario usuario=b.autenticar(login,senha);
		if(usuario!=null) {
			//guarda o usuario na session
			HttpSession sessao= request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:servletPrincipal?acao=ListaEmpresas";
		}else {
			return "redirect:servletPrincipal?acao=LoginForm";
		}
		
	}

}
