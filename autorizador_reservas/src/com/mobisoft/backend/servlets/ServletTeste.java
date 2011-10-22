package com.mobisoft.backend.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.backend.comunicacao.CreateJSONXStream;
import com.empresa.backend.comunicacao.Estabelecimento;
import com.empresa.backend.comunicacao.Restaurantes;
import com.empresa.backend.dao.ManagerDAO;
import com.empresa.backend.dao.RestauranteDAO;
import com.empresa.backend.entities.Restaurante;

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
		
		RestauranteDAO restDao = new RestauranteDAO();
		List<Restaurante> lista = restDao.getAll();
		ArrayList<Estabelecimento> rs = new ArrayList<Estabelecimento>();
		
		for(Restaurante r : lista)
			rs.add(new Estabelecimento(r.getId(), r.getNome(), r.getDescricao(), "88440962", r.getEmpresa().getEndereco(), r.getUrlLogo()));
		Restaurantes restaurantes = new Restaurantes();
		restaurantes.setRests(rs);	
		CreateJSONXStream cj = new CreateJSONXStream();
		String json2 = cj.getXs().toXML(restaurantes);
		System.out.println(json2);
		
		response.getWriter().append(json2);
		
		//response.sendError(530);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
