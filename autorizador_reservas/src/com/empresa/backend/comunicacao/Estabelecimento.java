package com.empresa.backend.comunicacao;


public class Estabelecimento {
	
	private long idrest;
	private String nome;
	private String descricao;
	private String telefone;
	private String endereco;
	private String urllogo;
	
	public Estabelecimento(long idrest, String nome, String descricao,
			String telefone, String endereco, String urllogo) {
		super();
		this.idrest = idrest;
		this.nome = nome;
		this.descricao = descricao;
		this.telefone = telefone;
		this.endereco = endereco;
		this.urllogo = urllogo;
	}

	public long getIdrest() {
		return idrest;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getUrllogo() {
		return urllogo;
	}



	public void setUrllogo(String urllogo) {
		this.urllogo = urllogo;
	}



	public void setIdrest(int idrest) {
		this.idrest = idrest;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
