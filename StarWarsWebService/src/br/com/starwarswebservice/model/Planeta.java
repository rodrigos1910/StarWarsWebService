package br.com.starwarswebservice.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe Reponsavel por conter os atributos do Objeto Planeta
 * @author rodri
 *
 */

@XmlRootElement
public final class Planeta {

	private Integer id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer quantidadeFilmes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Integer getQuantidadeFilmes() {
		return quantidadeFilmes;
	}
	public void setQuantidadeFilmes(Integer quantidadeFilmes) {
		this.quantidadeFilmes = quantidadeFilmes;
	}
	
	
}
