package model;

import java.util.Calendar;

public class Usuario {
	
	private int id;
	private String nome;
	private String email;
	private Calendar nascimento;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email, Calendar nascimento) {
		
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	
	public Calendar getNascimento() {
		return this.nascimento;
	}
}
