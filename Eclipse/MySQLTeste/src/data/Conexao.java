package data;

/* 
 * @Author: Eric Lau
 * 02/02/02 20:18
 * 
 * baixe o mysql-connector no site do mysql
 * 
 * clique com o botão direito em cima do projeto
 * clique em Build Path
 * clique em add external archives
 * selecione o mysql-connector
 * 
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/db_exemplo?useSSL=false";
	private static final String USUARIO = "root";
	private static final String SENHA = "mysql3306";
	
	public static Connection getConexao() {
		
		try {

			Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			return conexao;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void fecharConexao(Connection conexao){
		
		if(conexao != null) {
			try {
				conexao.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		}
	}
	
	public static void fecharConexao(Connection con, PreparedStatement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		fecharConexao(con);
	}
	
	public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		fecharConexao(con, stmt);
	}

}
