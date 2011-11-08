package com.empresa.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.empresa.backend.entities.Servico;

public class ServicoDAO implements DAOIF<Servico> {

	public List<Servico> getAll() {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Servico> l = (List<Servico>)s.createCriteria(Servico.class).list();
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l;
	}
	
	public Servico getServico(long id) {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		Criteria c = s.createCriteria(Servico.class);
		c.add(Restrictions.eq("id", id));
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Servico> l = (List<Servico>)s.createCriteria(Servico.class).list();
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l.get(0);
	}

	public Servico searchOne(Servico model) {

		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		Filter f = s.enableFilter("idServico");
		System.out.println(f.getFilterDefinition().getParameterNames());
		System.out.println(f.getFilterDefinition().getParameterTypes());
		f.setParameter("idBase", model.getId());
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
