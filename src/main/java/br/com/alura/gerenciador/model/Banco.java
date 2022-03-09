package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Banco {
	private static List<Empresa>lista=new ArrayList<>();
	private static List<Usuario>listaUsuarios=new ArrayList<>();
 private static Long chaveSequencial=1L;
	static {
		Empresa e1=new Empresa();
		e1.setNome("Google");
		e1.setId(chaveSequencial++);
		Empresa e2=new Empresa();
		e2.setNome("Microsoft");
		e2.setId(chaveSequencial++);
		
		Usuario user1= new Usuario();
		user1.setLogin("tam");
		user1.setSenha("123");
		
		Usuario user2= new Usuario();
		user2.setLogin("taci");
		user2.setSenha("123");
		lista.add(e1);
		lista.add(e2);
		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
	}
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
		
	}
	public List<Empresa>getEmpresas(){
		return Banco.lista;
	}
	public void remove(Long i) {
		
		Iterator <Empresa>it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp= it.next();
			if(emp.getId()==i) {
			it.remove();
			}
	}
	}
	public Empresa buscaEmpresaId(Long i) {
		
		for(Empresa e:lista) {
			if(e.getId()==i) {
				return e;
			}
			
		}
		return null;
		
	}
	public Usuario autenticar(String login, String senha) {
		// TODO Auto-generated method stub
		for(Usuario u:listaUsuarios) {
			if(u.ehIgual(login, senha)){
				return u;
			}
		}
		
		return null;
	}

}
