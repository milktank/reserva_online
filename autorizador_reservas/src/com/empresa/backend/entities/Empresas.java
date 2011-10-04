package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
}
