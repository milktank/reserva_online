package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empresa_restaurantes")
public class Restaurante {

	@Id
	@Column(name="id_restaurante")
	@GeneratedValue
	Long id;
	
	@Column(name="nome")
	String nome;
	@Column(name="descricao")
	String descricao;
	@Column(name="lat")
	Double latitude;
	@Column(name="long")
	Double longitude;
	@Column(name="url_logo")
	String urlLogo;
	
	@ManyToOne
	@JoinColumn(name="fk_empresa")
	Empresas empresa;
	
	@ManyToOne
	@JoinColumn(name="fk_categoria")
	CategoriaRestaurante categoria;

	public Restaurante(String nome, String descricao, Double latitude,
			Double longitude, String urlLogo, Empresas empresa,
			CategoriaRestaurante categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.urlLogo = urlLogo;
		this.empresa = empresa;
		this.categoria = categoria;
	}

	public Restaurante() {

		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

	public CategoriaRestaurante getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaRestaurante categoria) {
		this.categoria = categoria;
	}
}
