package com.empresa.backend.dao;

import java.util.List;

import org.hibernate.classic.Session;

import com.empresa.backend.entities.Servico;

public class ServicoDAO implements DAOIF<Servico> {

	public List<Servico> getAll() {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Servico> l = (List<Servico>)s.createCriteria(Servico.class);
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l;
	}

	public Servico searchOne(Servico model) {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		s.enableFilter("descricaoIgual").setParameter("descricaoIgual", model.getDescricao());
		@SuppressWarnings("unchecked")
		List<Servico> l = (List<Servico>)s.createCriteria(Servico.class).list();
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l.get(0);
	}

	public void insert(Servico serv) {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		
		s.save(serv);
		
		s.getTransaction().commit();
		
		s.close();
	}

	
}
