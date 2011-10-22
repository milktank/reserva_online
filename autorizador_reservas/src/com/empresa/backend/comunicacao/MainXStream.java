package com.empresa.backend.comunicacao;

import java.util.ArrayList;


public class MainXStream {
	
	public static void main(String[] args) {
		
		CreateJSONXStream cj = new CreateJSONXStream();
		
		Estabelecimento r1 = new Estabelecimento();
		r1.setNome("rest01");
		r1.setDescricao("aaa");
		
		Estabelecimento r2 = new Estabelecimento();
		r2.setNome("rest02");
		r2.setDescricao("bbb");
		
		//String json1 = cj.getXs().toXML(r1);
		
		ArrayList<Estabelecimento> rs = new ArrayList<Estabelecimento>();
		rs.add(r1);
		rs.add(r2);
		
		Restaurantes restaurantes = new Restaurantes();
		restaurantes.setRests(rs);
		
		String json2 = cj.getXs().toXML(restaurantes);
		
		System.out.println(json2);
		
	}

}
