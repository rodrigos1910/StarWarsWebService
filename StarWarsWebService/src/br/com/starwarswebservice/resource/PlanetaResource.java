package br.com.starwarswebservice.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import br.com.starwarswebservice.controller.PlanetaController;
import br.com.starwarswebservice.helper.ConsumoHttp;
import br.com.starwarswebservice.model.Planeta;
import br.com.starwarswebservice.model.Result;
import br.com.starwarswebservice.model.ResultElement;



/**
 * Classe responsavel por conter os metodos REST de acesso ao webservice
 * @author rodri
 *
 */

@Path("/planeta")
public class PlanetaResource {

	

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Planeta> listarTodos(){
		return new PlanetaController().listarTodos();
	}
	
	
	@GET
	@Path("/listarTodosApiStarWars")
	@Produces("application/json")
	public  ArrayList<Planeta> listarTodosApiStarWars(){
		
		Result retorno = null;
		ArrayList<Planeta> planetas = null;
		
		JsonObject json = null;
		Gson gson = null;
		
		planetas = new ArrayList<Planeta>();
		
		try {
			ConsumoHttp ch = new ConsumoHttp();
			
			
			json = ch.Get("https://swapi.co/api/planets/?format=json");			
			gson = new Gson();
			retorno =  gson.fromJson(json, Result.class);
			
			for(ResultElement res : retorno.getResults()){
				Planeta p = new Planeta();
				p.setClima(res.getClimate());
				p.setNome(res.getName());
				p.setTerreno(res.getTerrain());
				p.setQuantidadeFilmes(res.getFilms().length);
				
				planetas.add(p);
				
			}
			
			
		}catch(Exception e){
			System.out.println("Erro ao listar planetas:"+e);
			e.printStackTrace();		}
						
        
        return planetas;  
      
        
	}
		

	@GET
	@Path("/listarPorNome/{param}")
	@Produces("application/json")
	public ArrayList<Planeta> listarPorNome(@PathParam("param") String nome){
		return new PlanetaController().listarPorNome(nome);
	}
	

	@GET
	@Path("/listarPorId/{param}")
	@Produces("application/json")
	public ArrayList<Planeta> listarPorId(@PathParam("param") Integer id){
		return new PlanetaController().listarPorId(id);
	}
		

	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public ArrayList<Planeta> inserir(String content) throws Exception{
		Gson g = new Gson();
		ConsumoHttp ch = new ConsumoHttp();
		JsonObject json = null;
		int qtd = 0 ;
		
		Planeta planeta = (Planeta) g.fromJson(content, Planeta.class);		
		
		json = ch.Get("https://swapi.co/api/planets/?format=json&search="+planeta.getNome());			
		g = new Gson();
		Result retorno =  g.fromJson(json, Result.class);
		
		
		if (retorno != null) {
			if (retorno.getResults().length > 0) {
				qtd = retorno.getResults()[0].getFilms().length;				
			}			
		}
		
		planeta.setQuantidadeFilmes(qtd);
		
		return new PlanetaController().inserir(planeta);
		
		
	}
	
	@DELETE
	@Path("/{param}")
	@Produces("application/json")
	public Response  deletar(@PathParam("param") Integer id){
		
		boolean response = new PlanetaController().deletar(id);
	
	    return Response.ok().entity(String.valueOf(response)).build();
	    
			
	}
	
	
}
