package com.empresa.backend.comunicacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;


public class CreateJSONXStream {
	
	private XStream xs;
	
	public CreateJSONXStream(){
		xs = new XStream(new JsonHierarchicalStreamDriver());
		createAlias();
	}

	private void createAlias() {
		xs.alias("restaurantes", Estabelecimento.class);
		
		xs.alias("estabelecimentos", Restaurantes.class);
	}

	public XStream getXs() {
		return xs;
	}

	public void setXs(XStream xs) {
		this.xs = xs;
	}
}
