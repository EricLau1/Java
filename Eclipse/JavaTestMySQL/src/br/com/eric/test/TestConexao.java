package br.com.eric.test;

import java.sql.Connection;

import br.com.eric.db.Conexao;

public class TestConexao {

	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			con = Conexao.conectar();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Conexao.fechar(con);
		}

	}

}
