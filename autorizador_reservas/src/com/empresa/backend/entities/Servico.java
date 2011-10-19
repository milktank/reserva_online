package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;


@Entity
@Table(name="mobsoft_servicos")
@FilterDef(name="descricaoIgual", parameters=@ParamDef( name="descricaoIgual", type="string" ))
@Filters( {
    @Filter(name="mesmaDescricao", condition="descricao like %:descricaoIgual%")
} )
public class Servico {

	@Id
	@Column(name="id_servico")
	@GeneratedValue
	Long id;
	
	@Column(name="descricao")
	String descricao;
	@Column(name="valor")
	Float valor;

	@ManyToOne
	@JoinColumn(name="fk_id_empresa")
	Empresas empresa;
	
	public Servico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servico(String descricao, Float valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Float getValor() {
		return valor;
	}



	public void setValor(Float valor) {
		this.valor = valor;
	}



	public Empresas getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}



	@Override
	public String toString() {

		return this.descricao + " " + this.id + " " + this.valor;
	}
}
