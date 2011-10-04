package com.empresa.backend.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	//@ForeignKey(name = "id_servico")
	@OneToOne
	@JoinColumn(name="id_servico")
	Long idServico;
	
}
