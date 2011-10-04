package com.empresa.backend.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="votty_usuarios")
public class Usuarios {

	@GeneratedValue
	@Id
	Long idUsuario;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="imei")
	String imei;
}
