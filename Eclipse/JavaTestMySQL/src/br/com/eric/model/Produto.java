package br.com.eric.model;

import java.time.LocalDateTime;

public class Produto {
	
	private int id;
	private String descricao;
	private double valor;
	private LocalDateTime dataRegistro;
	
	public Produto() {
		
	}
	
	public Produto(int id, String descricao, double valor, LocalDateTime dataRegistro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataRegistro = dataRegistro;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	@Override
	public String toString() {
		return "{" + 
			   "\t\"id\":\t" + this.getId() + "\n" +
			   "\t\"descricao\":\t" + this.getDescricao() + "\n" + 
			   "\t\"valor\":\t" + this.getValor() + "\n" + 
			   "\t\"data_registro\":\t" + this.getDataRegistro() + "\n" +
			   "}\n";
	}
}
