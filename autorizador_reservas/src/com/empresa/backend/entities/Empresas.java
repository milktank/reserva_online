package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mobsoft_empresas")
public class Empresas {

	@Column(name="nome")
	String nome;
	
	@Column(name="cnpj")
	String cnpj;
	
	@Column(name="endereco")
	String endereco;
	
	@GeneratedValue
	@Id
	@Column(name="id_empresa")
	Long id_empresa;
	
	public Empresas() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Empresas(String nome, String cnpj, String endereco) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

}
