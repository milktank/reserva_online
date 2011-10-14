package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="mobsoft_servicos")
public class Servico {

	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="descricao")
	String descricao;
	@Column(name="valor")
	Float valor;

	@ManyToOne
	@JoinColumn(name="fk_id_empresa")
	Empresas empresa;

	public Servico(String descricao, Float valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
}
