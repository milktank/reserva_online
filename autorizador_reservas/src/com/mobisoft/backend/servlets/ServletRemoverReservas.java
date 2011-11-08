package com.mobisoft.backend.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.backend.dao.ReservaDAO;
import com.empresa.backend.entities.Reserva;

/**
 * Servlet implementation class ServletRemoverReservas
 */
@WebServlet("/ServletRemoverReservas")
public class ServletRemoverReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservaDAO resDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRemoverReservas() {
		super();
		resDao = new ReservaDAO();
	}

	public void removerReserva(long id){
		Reserva r = resDao.getReserva(id);
		resDao.remove(r);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id!=null && !id.isEmpty()){
			removerReserva(Long.parseLong(id));
		}
		
		javax.servlet.RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}

}
