package com.mobisoft.backend.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.backend.dao.ManagerDAO;
import com.empresa.backend.regra.SistemaReserva;

/**
 * Servlet implementation class ServletTeste
 */
@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SistemaReserva sisReserv;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		new ManagerDAO(); //para criar a factory
		this.sisReserv = new SistemaReserva();
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
		
		Integer tipoReq;
		
		/*System.out.println("teste");
		ReservaDAO rDao = new ReservaDAO(); //criando novo DAO de reserva para
		ServicoDAO sDao = new ServicoDAO();
		Servico serv = new Servico("servicin", 2f);
		sDao.insert(serv);
		System.out.println(serv);
		Date data = new Date();
		data.setTime(Calendar.getInstance().getTimeInMillis());
		rDao.insert(new Reserva(data, "123", serv));*/
		
		/*ServicoDAO sDao = new ServicoDAO();
		Servico serv = new Servico("servicin", 2f);
		System.out.println(sDao.searchOne(serv));*/
		
		/*CategoriaRestaurante cr = new CategoriaRestaurante("Restaurantes Chines", "Todos Chineses");
		new CategoriaRestauranteDAO().insert(cr);
		
		Empresas e = new Empresas("Empresa dos Chines", "0987654321", "Epitácio Pessoa");
		new EmpresaDAO().insert(e);
		
		Restaurante r = new Restaurante("China InBox2", "In Box2 Epitácio", 1.4d, 1.5d, "http://www.myigadget.com/blog-en/blog/wp-content/uploads/2011/04/93aadd95iphone3g-4.jpg", e, cr);
		RestauranteDAO restDao = new RestauranteDAO();
		restDao.insert(r);*/
		
		tipoReq = Integer.parseInt(request.getParameter("tipo"));
		
		switch (tipoReq) {
		case 1:
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			Long idServico = Long.parseLong(request.getParameter("servico"));
			String data = request.getParameter("data");
			this.sisReserv.makeReserva(nome, telefone, data, idServico);
			response.getWriter().append("ok");
			break;
		case 2 :
			response.getWriter().append(this.sisReserv.jsonRestaurantes());
			break;
		default:
			break;
		}
		
		//response.sendError(530);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
