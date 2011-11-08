package com.empresa.backend.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.empresa.backend.entities.Reserva;

public class ReservaDAO implements DAOIF<Reserva>{

	public ReservaDAO() {
		
		
	}
	
	public List<Reserva> getReservasDiarias(long idServico){
		Session session = ManagerDAO.factory.openSession();
		session.beginTransaction();
		
		Calendar c =Calendar.getInstance();
		String data = c.get(Calendar.DAY_OF_MONTH)+ "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR);
		
		String sql = "select * from votty_reservas r where r.id_servico = " + idServico+
					" and cast(r.data_reserva as DATE) = '" + data + "'";   
		
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Reserva.class);

		List<Reserva> reservas= query.list();  

		session.getTransaction().commit();
		session.close();

		return reservas;
	}
	
	public Reserva getReserva(long id){

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();

		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		Criteria c = s.createCriteria(Reserva.class);
		c.add(Restrictions.eq("idReserva", id));
//		c.setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<Reserva> l = (List<Reserva>)c.list();

		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		if(l!= null)
			return l.get(0);
		
		return null;
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
	
	public void insert(Reserva r){
		
		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		
		s.save(r);
		
		s.getTransaction().commit();
		
		s.close();
	}
	
	public void remove(Reserva r){

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();

		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();

		s.delete(r);

		s.getTransaction().commit();

		s.close();
	}
	
	public void update(Reserva r){

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();

		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();

		s.update(r);

		s.getTransaction().commit();

		s.close();
	}


	@Override
	public Reserva searchOne(Reserva model) {

		return null;
	}
}
