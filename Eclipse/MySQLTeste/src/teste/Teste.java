package teste;

import model.Usuario;

import java.util.Calendar;

import java.sql.Date;

import data.UsuarioDao;

public class Teste {
	
	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setNome("Jane Doe");
		u.setEmail("jane@email.com");
		Calendar nascimento = Calendar.getInstance();
		nascimento.set(2000, 1, 1); // Ano, Mes, Dia
		u.setNascimento(nascimento);
		
		UsuarioDao dao = new UsuarioDao();
		/*boolean sucess = dao.insert(u);
		
		if(sucess) {
			System.out.println("novo usuario adicionado com sucesso!");
		}*/
		
		// Percorrendo lista de usuarios 
		for(Usuario list : dao.select()) {
			System.out.println(
					"nome: " + list.getNome() +
					", Email: " + list.getEmail() +
					", Nascimento: " + new Date(list.getNascimento().getTimeInMillis()));
		}
		
		
	} // fim main

}
