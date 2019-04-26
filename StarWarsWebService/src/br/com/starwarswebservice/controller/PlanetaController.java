package br.com.starwarswebservice.controller;

import java.util.ArrayList;

import br.com.starwarswebservice.dao.PlanetaDAO;
import br.com.starwarswebservice.model.Planeta;



/**
 * Classe responsavel por ser o controlador entre o resource e a camada DAO
 * @author rodri
 *
 */
public class PlanetaController {
	
	public ArrayList<Planeta> listarTodos(){
		return PlanetaDAO.getInstance().listarTodos();
	}

	public ArrayList<Planeta> listarPorNome(String nome){
		return PlanetaDAO.getInstance().listarPorNome(nome);
	}

	public ArrayList<Planeta> listarPorId(Integer id){
		return PlanetaDAO.getInstance().listarPorId(id);
	}

	public ArrayList<Planeta> inserir(Planeta planeta){
		return PlanetaDAO.getInstance().inserir(planeta);
	}
	
	public boolean  deletar(Integer id){
		return PlanetaDAO.getInstance().deletar(id);
	}

}
