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
	
	@Column(name="data_reserva")
	Date dataReserva;
	@Column(name="imei_dispositivo")
	String imei;
	
	@Column(name="item_reservado")
	String item;
	
	@ManyToOne
	@JoinColumn(name="id_servico")
	Servico servico;

	public Reserva(Date dataReserva, String imei, Servico s){
		
		this.dataReserva = dataReserva;
		this.imei = imei;
		this.servico = s;
	}
}