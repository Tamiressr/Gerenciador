package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;

public class Banco {
	private static List<Empresa>lista=new ArrayList<>();
 private static Long chaveSequencial=1L;
	static {
		Empresa e1=new Empresa();
		e1.setNome("Google");
		e1.setId(chaveSequencial++);
		Empresa e2=new Empresa();
		e2.setNome("Microsoft");
		e2.setId(chaveSequencial++);
		lista.add(e1);
		lista.add(e2);
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

}
