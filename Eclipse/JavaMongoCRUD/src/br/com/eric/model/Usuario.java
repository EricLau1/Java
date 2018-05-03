package br.com.eric.model;

import java.time.LocalDate;

public class Usuario {
	
	private Long id;
	private String nome;
	private LocalDate nascimento;
	private String email;
	private String senha;
	private boolean online;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, LocalDate nascimento, String email, String senha, boolean online) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
		this.senha = senha;
		this.online = online;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	
}
