package com.empresa.backend.dao;

import java.util.List;

import org.hibernate.classic.Session;

import com.empresa.backend.entities.Reserva;

public class ReservaDAO {

	public ReservaDAO() {
		
		
	}

	public List<Reserva> getAll(){
		
		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Reserva> l = (List<Reserva>)s.createCriteria(Reserva.class);
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l;
	}
	
	public void save(Reserva r){
		
		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		
		s.save(r);
		
		s.getTransaction().commit();
		
		s.close();
	}
}
