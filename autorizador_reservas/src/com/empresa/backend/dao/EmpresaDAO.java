package com.empresa.backend.dao;

import java.util.List;

import org.hibernate.classic.Session;

import com.empresa.backend.entities.Empresas;

public class EmpresaDAO implements DAOIF<Empresas>{

	public EmpresaDAO() {
		
		
	}

	public List<Empresas> getAll(){
		
		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Empresas> l = (List<Empresas>)s.createCriteria(Empresas.class);
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l;
	}
	
	public void insert(Empresas r){
		
		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		
		s.save(r);
		
		s.getTransaction().commit();
		
		s.close();
	}

	@Override
	public Empresas searchOne(Empresas model) {

		return null;
	}
}
