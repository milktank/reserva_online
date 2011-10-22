package com.empresa.backend.comunicacao;

import java.util.ArrayList;


public class Restaurantes {
	
	private ArrayList<Estabelecimento> rests;
	
	public Restaurantes(){
		rests = new ArrayList<Estabelecimento>();
	}

	public ArrayList<Estabelecimento> getRests() {
		return rests;
	}

	public void setRests(ArrayList<Estabelecimento> rests) {
		this.rests = rests;
	}
}
