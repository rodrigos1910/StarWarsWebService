package br.com.starwarswebservice.factory;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;


/**
 * Classe responsavel por conter os metodos de conexao com o banco de dados
 * @author rodri
 *
 */

public class ConnectionFactory {

	//Conexão com o Banco de Dados

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String SERVIDOR = "starwarsdb.mysql.dbaas.com.br";
	private static final String BANCODEDADOS = "starwarsdb";
	private static final String URL = "jdbc:mysql://" + SERVIDOR + "/" + BANCODEDADOS;;
	private static final String USUARIO = "starwarsdb";
	private static final String SENHA = "teste@123";
	
	
	
	
	public Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
			
			
			
		} catch(Exception e) {
			System.out.println("Erro ao criar conexão com o banco: "+ URL);
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	
	
	

	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(conexao != null) {
				conexao.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
				
		} catch(Exception e) {
			System.out.println("Erro ao fechar conexao.");
		}
		
		
	}
	
	
	
}
