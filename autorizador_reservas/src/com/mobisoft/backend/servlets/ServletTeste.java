package com.mobisoft.backend.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.backend.dao.ManagerDAO;
import com.empresa.backend.dao.ReservaDAO;
import com.empresa.backend.entities.Reserva;
import com.empresa.backend.entities.Servico;

/**
 * Servlet implementation class ServletTeste
 */
@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		new ManagerDAO(); //para criar a factory
	}
	
    /**
     * Default constructor. 
     */
    public ServletTeste() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("teste");
		ReservaDAO rDao = new ReservaDAO(); //criando novo DAO de reserva para
		Servico serv = new Servico("servicin", 2f);
		Date data = new Date();
		data.setTime(Calendar.getInstance().getTimeInMillis());
		rDao.insert(new Reserva(data, "123", serv));
		response.sendError(530);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
