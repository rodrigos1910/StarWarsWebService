package br.com.starwarswebservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.starwarswebservice.factory.ConnectionFactory;
import br.com.starwarswebservice.model.Planeta;

public class PlanetaDAO extends ConnectionFactory {
	
	
	private static PlanetaDAO instance;
	
	public static PlanetaDAO getInstance() {
		if(instance == null) 
			instance = new PlanetaDAO();
			return instance;
	}
	
	

	public ArrayList<Planeta> listarTodos(){
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Planeta> planetas = null;
		
		
		conexao = criarConexao();
		planetas = new ArrayList<Planeta>();
		
		try {
			
			pstmt = conexao.prepareStatement("select * from Planeta order by id");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Planeta planeta = new Planeta();

				planeta.setId(rs.getInt("id"));
				planeta.setNome(rs.getString("nome"));
				planeta.setClima(rs.getString("clima"));
				planeta.setTerreno(rs.getString("terreno"));
				planeta.setQuantidadeFilmes(rs.getInt("quantidadeFilmes"));
				
				planetas.add(planeta);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Erro ao listar planetas:"+e);
			e.printStackTrace();
			
		}finally {
			fecharConexao(conexao,pstmt,rs);
		}
		
		return planetas;
	}
	
	
	
	public ArrayList<Planeta> listarPorNome(String nome){
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Planeta> planetas = null;
		
		
		conexao = criarConexao();
		planetas = new ArrayList<Planeta>();
		
		try {
			
			pstmt = conexao.prepareStatement("select * from Planeta where nome like ? order by id");
			pstmt.setString(1, nome+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Planeta planeta = new Planeta();

				planeta.setId(rs.getInt("id"));
				planeta.setNome(rs.getString("nome"));
				planeta.setClima(rs.getString("clima"));
				planeta.setTerreno(rs.getString("terreno"));
				planeta.setQuantidadeFilmes(rs.getInt("quantidadeFilmes"));
				
				planetas.add(planeta);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Erro ao listar planetas:"+e);
			e.printStackTrace();
			
		}finally {
			fecharConexao(conexao,pstmt,rs);
		}
		
		return planetas;
	}
	
	
	public ArrayList<Planeta> listarPorId(Integer id){
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Planeta> planetas = null;
		
		
		conexao = criarConexao();
		planetas = new ArrayList<Planeta>();
		
		try {
			
			pstmt = conexao.prepareStatement("select * from Planeta where id = ? order by id");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Planeta planeta = new Planeta();

				planeta.setId(rs.getInt("id"));
				planeta.setNome(rs.getString("nome"));
				planeta.setClima(rs.getString("clima"));
				planeta.setTerreno(rs.getString("terreno"));
				planeta.setQuantidadeFilmes(rs.getInt("quantidadeFilmes"));
				
				planetas.add(planeta);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Erro ao listar planetas:"+e);
			e.printStackTrace();
			
		}finally {
			fecharConexao(conexao,pstmt,rs);
		}
		
		return planetas;
	}
	
	
	
	
	public ArrayList<Planeta> inserir(Planeta planeta){
			
			Connection conexao = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<Planeta> planetas = null;
			
			
			conexao = criarConexao();
			planetas = new ArrayList<Planeta>();
			
			try {
				
				pstmt = conexao.prepareStatement("INSERT INTO Planeta (nome, clima, terreno, quantidadeFilmes) VALUES (?, ?, ?, ?);",pstmt.RETURN_GENERATED_KEYS);
				pstmt.setString(1,planeta.getNome());
				pstmt.setString(2,planeta.getClima());
				pstmt.setString(3,planeta.getTerreno());
				pstmt.setInt(4,planeta.getQuantidadeFilmes());
				pstmt.execute();
				
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
				    planetas = this.listarPorId(rs.getInt(1));
				}
				
							
				
			}catch(Exception e) {
				System.out.println("Erro ao Inserir planeta:"+e);
				e.printStackTrace();
				
			}finally {
				fecharConexao(conexao,pstmt,rs);
			}
			
			return planetas;
		}
	
	
	public boolean  deletar(Integer id){
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean retorno = false;
		
		
		conexao = criarConexao();
		
		try {
			
			pstmt = conexao.prepareStatement("DELETE FROM Planeta WHERE id = ?");
			pstmt.setInt(1,id);
			
			 pstmt.executeUpdate();
	         retorno = true;
	           
						
			
		}catch(Exception e) {
			System.out.println("Erro ao excluir planeta:"+e);
			e.printStackTrace();
			 retorno = false;
			
		}finally {
			fecharConexao(conexao,pstmt,rs);
		}
		
		return retorno;
	}
	
	
	
}
