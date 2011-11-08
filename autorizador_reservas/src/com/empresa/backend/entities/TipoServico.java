package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresa_tipo_servico")
public class TipoServico {

	@Id
	@GeneratedValue
	@Column(name="id_tipo_servico")
	Long id_tipo_servico;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="descricao")
	String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
