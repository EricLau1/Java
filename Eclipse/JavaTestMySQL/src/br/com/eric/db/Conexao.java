package br.com.eric.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection conectar() {
		
		final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
		final String USER = "root";
		final String SENHA = "";
		
		Connection con = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, SENHA);
			
			System.out.println("Conexão bem sucedida!");
			
			return con;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void fechar(Connection con) {
		
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void fechar(Connection con, PreparedStatement stmt) {
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		fechar(con);
	}
	
	public static void fechar(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		fechar(con, stmt);
	}
}
