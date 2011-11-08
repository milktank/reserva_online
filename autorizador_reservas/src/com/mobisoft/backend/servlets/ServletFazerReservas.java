package com.mobisoft.backend.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.backend.dao.ReservaDAO;
import com.empresa.backend.dao.ServicoDAO;
import com.empresa.backend.entities.Reserva;
import com.empresa.backend.entities.Servico;

/**
 * Servlet implementation class ServletFazerReservas
 */
@WebServlet("/ServletFazerReservas")
public class ServletFazerReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservaDAO resDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFazerReservas() {
        super();
        resDao = new ReservaDAO();
    }
    
    public void fazerReserva(Reserva r){
    	resDao.insert(r);
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
		String id_serv = request.getParameter("id_servico");
		System.out.println("serviço: " + id_serv);
		Servico serv = (Servico) new ServicoDAO().getServico(Long.parseLong(id_serv));
		
		String nome = request.getParameter("nome");
		
		String imei = request.getParameter("imei");
		
		String tel = request.getParameter("tel");
		
		String stDia = request.getParameter("dia");
		String stMes = request.getParameter("mes");
		String stAno = request.getParameter("ano");
		
		String stHora = request.getParameter("hora");
		
		Date data = new Date();
		data.setDate(Integer.parseInt(stDia));
		data.setMonth(Integer.parseInt(stMes));
		data.setYear(Integer.parseInt(stAno));
		
		data.setHours(Integer.parseInt(stHora));
		
		Reserva r = new Reserva(nome, data, serv, tel);
		r.setImei(imei);
		
		resDao.insert(r);

		javax.servlet.RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}

}
