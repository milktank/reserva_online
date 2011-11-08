package com.empresa.backend.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="votty_reservas")
public class Reserva {
	
	
	@Id
	@GeneratedValue
	@Column(name="id_reserva")
	Long idReserva;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="data_reserva")
	Date dataReserva;
	@Column(name="imei_dispositivo")
	String imei;
	
	@Column(name="item_reservado")
	String item;
	
	@ManyToOne
	@JoinColumn(name="id_servico")
	Servico servico;
	
	@Column(name="telefone")
	String telefone;
	
	public Reserva() {
		super();
	}

	public Reserva(Long idReserva, String nome, Date dataReserva, String imei,
			String item, Servico servico, String telefone) {
		super();
		this.idReserva = idReserva;
		this.nome = nome;
		this.dataReserva = dataReserva;
		this.imei = imei;
		this.item = item;
		this.servico = servico;
		this.telefone = telefone;
	}
	
	public Reserva(String nome, Date dataReserva, Servico servico, String telefone) {
		super();
		this.nome = nome;
		this.dataReserva = dataReserva;
		this.servico = servico;
		this.telefone = telefone;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
