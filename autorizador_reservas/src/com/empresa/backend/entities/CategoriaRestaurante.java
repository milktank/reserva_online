package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresa_categoria_restaurantes")
public class CategoriaRestaurante {

	@Id
	@Column(name="id_categoria")
	@GeneratedValue
	Long id;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="descricao")
	String descricao;
	
	public CategoriaRestaurante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaRestaurante(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
