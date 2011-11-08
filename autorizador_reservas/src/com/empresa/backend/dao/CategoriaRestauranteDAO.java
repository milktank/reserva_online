package com.empresa.backend.dao;

import java.util.List;
import org.hibernate.classic.Session;
import com.empresa.backend.entities.CategoriaRestaurante;

public class CategoriaRestauranteDAO implements DAOIF<CategoriaRestaurante>{

	public CategoriaRestauranteDAO() {
		
		
	}

	public List<CategoriaRestaurante> getAll(){
		
		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<CategoriaRestaurante> l = (List<CategoriaRestaurante>)s.createCriteria(CategoriaRestaurante.class);
		
		//finaliizando transacao
		s.getTransaction().commit();
		s.close();
		
		return l;
	}
	
	public void insert(CategoriaRestaurante r){
		
		//Obtendo sessão
		Session s = ManagerDAO.factory.openSession();
		
		//iniciando transacao e obtendo todos os objetos
		s.beginTransaction();
		
		s.save(r);
		
		s.getTransaction().commit();
		
		s.close();
	}

	@Override
	public CategoriaRestaurante searchOne(CategoriaRestaurante model) {

		return null;
	}
}
