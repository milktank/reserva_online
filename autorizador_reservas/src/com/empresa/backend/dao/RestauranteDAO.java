package com.empresa.backend.dao;

import java.util.List;

import org.hibernate.classic.Session;
import com.empresa.backend.entities.Restaurante;

public class RestauranteDAO implements DAOIF<Restaurante> {

	public List<Restaurante> getAll() {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Restaurante> l = (List<Restaurante>)s.createCriteria(Restaurante.class).list();
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l;
	}

	/*public Restaurante searchOne(Restaurante model) {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		s.enableFilter("descricaoIgual").setParameter("descricaoIgual", model.getDescricao());
		@SuppressWarnings("unchecked")
		List<Restaurante> l = (List<Restaurante>)s.createCriteria(Restaurante.class).list();
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l.get(0);
	}*/

	public void insert(Restaurante rest) {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		
		s.save(rest);
		
		s.getTransaction().commit();
		
		s.close();
	}

	@Override
	public Restaurante searchOne(Restaurante model) {
		// TODO Auto-generated method stub
		return null;
	}
}
