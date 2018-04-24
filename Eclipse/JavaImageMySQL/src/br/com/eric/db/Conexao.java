package br.com.eric.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/javaimages?useSSL=false";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public static Connection getConexao() {
		Connection con = null;
		try {
			
			con = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Banco conectado com sucesso!");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	
	public static void fecharConexao(Connection c) {
		try {
			
			if(c != null) {
				c.close();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void fecharConexao(Connection c, PreparedStatement stmt) {
		try {
			
			if(stmt != null) {
				stmt.close();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		fecharConexao(c);
	}
	
	public static void fecharConexao(Connection c, PreparedStatement stmt, ResultSet rs) {
		try {
			
			if(rs != null) {
				rs.close();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		fecharConexao(c, stmt);
	}

}
