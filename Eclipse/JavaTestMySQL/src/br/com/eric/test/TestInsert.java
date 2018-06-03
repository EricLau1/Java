package br.com.eric.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import br.com.eric.db.Conexao;
import br.com.eric.model.Produto;

public class TestInsert {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO produto (descricao, valor, data_registro) VALUES ( ? , ? , ? )";
			
		Produto produto = new Produto();
		produto.setId(10);
		produto.setDescricao("teste");
		produto.setValor(10.74);
		produto.setDataRegistro(LocalDateTime.now());
		
		try {
			
			con = Conexao.conectar();
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, produto.getDescricao());
			stmt.setDouble(2, produto.getValor());
			stmt.setString(3, produto.getDataRegistro() + "");
			
			stmt.executeUpdate();
				
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		
		} finally {
		
			Conexao.fechar(con, stmt);
		
		}
	}
	
}
