package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private static List<Empresa>lista=new ArrayList<>();

	static {
		Empresa e1=new Empresa();
		e1.setNome("Google");
		Empresa e2=new Empresa();
		e2.setNome("Microsoft");
		lista.add(e1);
		lista.add(e2);
	}
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		lista.add(empresa);
		
	}
	public List<Empresa>getEmpresas(){
		return Banco.lista;
	}

}
