package com.empresa.backend.regra;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.empresa.backend.comunicacao.CreateJSONXStream;
import com.empresa.backend.comunicacao.Estabelecimento;
import com.empresa.backend.comunicacao.Restaurantes;
import com.empresa.backend.dao.ReservaDAO;
import com.empresa.backend.dao.RestauranteDAO;
import com.empresa.backend.dao.ServicoDAO;
import com.empresa.backend.entities.Reserva;
import com.empresa.backend.entities.Restaurante;
import com.empresa.backend.entities.Servico;

public class SistemaReserva {

	private ServicoDAO sDao;
	private ReservaDAO rDao;
	private RestauranteDAO restDao;
	
	private enum ENUM_TIPO_BUSCA {
		RESTAURANTES,
		SERVICOS,
		EMPRESAS
	};
	
	public SistemaReserva() {
		
		super();
		this.sDao = new ServicoDAO();
		this.rDao = new ReservaDAO();
		this.restDao = new RestauranteDAO();
	}

	public void makeReserva(String nome, String telefone, String dataFormatada, Long idServico){
		
		String partesData[] = dataFormatada.split("-");
		Calendar d = Calendar.getInstance();
		Servico s = new Servico();
		s.setId(idServico);
		d.set(Integer.parseInt(partesData[2]), Integer.parseInt(partesData[1]) - 1, Integer.parseInt(partesData[0]));
		
		rDao.insert(new Reserva(nome, d.getTime(), sDao.searchOne(s), telefone));
	}
	
	public List listaObjetos(ENUM_TIPO_BUSCA tipo){
		
		switch (tipo) {
		case RESTAURANTES:
			return restDao.getAll();
		default:
			break;
		}
		return null;
	}
	
	public String jsonRestaurantes(){
		
		ArrayList<Estabelecimento> le = new ArrayList<Estabelecimento>();
		List<Restaurante> rs = (List<Restaurante>)this.listaObjetos(ENUM_TIPO_BUSCA.RESTAURANTES);
 		
		for(Restaurante r : rs)
			le.add(new Estabelecimento(r.getId(), r.getNome(), r.getDescricao(), "88440962", r.getEmpresa().getEndereco(), r.getUrlLogo()));
		Restaurantes restaurantes = new Restaurantes();
		restaurantes.setRests(le);	
		CreateJSONXStream cj = new CreateJSONXStream();
		return cj.getXs().toXML(restaurantes);
	}
}
