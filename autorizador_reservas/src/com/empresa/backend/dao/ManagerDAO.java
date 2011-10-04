package com.empresa.backend.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.empresa.backend.entities.Empresas;
import com.empresa.backend.entities.Reserva;
import com.empresa.backend.entities.Servico;
import com.empresa.backend.entities.Usuarios;

public class ManagerDAO {

	public static SessionFactory factory = null;
	
	public ManagerDAO(){
	
		super();
	
		AnnotationConfiguration configuration = new AnnotationConfiguration();  
		  
	    String conn = "jdbc:postgresql://localhost:5432/mobsoft";  
	    String user = "postgres";  
	    String senha = "senha123";  
	
	    //Conexão com o banco
	    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	    configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");  
	    configuration.setProperty("hibernate.connection.url", conn);    
	    configuration.setProperty("hibernate.connection.username", user);    
	    configuration.setProperty("hibernate.connection.password", senha);  
	      
	    configuration.setProperty("hibernate.c3p0.min_size", "1");  
	    configuration.setProperty("hibernate.c3p0.max_size", "15");  
	    configuration.setProperty("hibernate.c3p0.timeout", "15");  
	    configuration.setProperty("hibernate.c3p0.idle_test_period", "0");  
	    configuration.setProperty("query.substitutions", "true 1, false 0, yes 'Y', no 'N'");  
	  
	    configuration.setProperty("hibernate.show_sql", "false");  
	      
	    configuration.setProperty("hibernate.hbm2ddl.auto", "update");  
	
	    /** 
	     * mapeamento 
	     */    
	    configuration.addAnnotatedClass(Empresas.class);  
	    configuration.addAnnotatedClass(Reserva.class);
	    configuration.addAnnotatedClass(Servico.class);  
	    configuration.addAnnotatedClass(Usuarios.class);
	      
	    ManagerDAO.factory = configuration.buildSessionFactory();
	}
}
