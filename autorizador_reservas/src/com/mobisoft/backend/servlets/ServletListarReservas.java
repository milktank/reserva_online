package com.mobisoft.backend.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.empresa.backend.dao.ManagerDAO;
import com.empresa.backend.dao.ReservaDAO;
import com.empresa.backend.entities.Reserva;


/**
 * Servlet implementation class ServletListarReservas
 */
@WebServlet("/ServletListarReservas")
public class ServletListarReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private ReservaDAO resDao;
	private Session session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListarReservas() {
		super();
		new ManagerDAO();
		this.resDao = new ReservaDAO();
	}

//	lista reservas do dia corrente
	@SuppressWarnings("unchecked")
	public List<Reserva> listarReservas(long idServico){
		return resDao.getReservasDiarias(idServico);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		javax.servlet.RequestDispatcher rd = null;

		//		long idServico = Long.parseLong(request.getParameter("idServico")); 
		//		List<Reserva> r = listarReservas(idServico);

		List<Reserva> r = listarReservas(5l);

		request.setAttribute("reservas", r);

		rd = getServletContext().getRequestDispatcher("/listarreservas.jsp");
		rd.forward(request, response);
	}

}
