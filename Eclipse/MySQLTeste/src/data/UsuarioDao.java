package data;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UsuarioDao {
	
	private Connection con = null;
	
	public boolean insert(Usuario u) {
		
		con = Conexao.getConexao();
		
		PreparedStatement stmt = null;
		
		String sql = "insert into usuario (nome, email, nascimento) values (?, ?, ?)";
		
		boolean sucess = false;
		
		try {
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			
			stmt.setDate(3, new Date(u.getNascimento().getTimeInMillis()));
			
			stmt.executeUpdate();
			
			sucess = true; // update realizado com sucesso!
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		} finally {
			Conexao.fecharConexao(con, stmt);
		}
		
		return sucess;
	}
	
	public List<Usuario> select() {
		
		con = Conexao.getConexao();
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select id, nome, email, nascimento from usuario";
		
		try {
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("nascimento"));
				usuario.setNascimento(data);
				
				lista.add(usuario);
				
			} // fim while
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			Conexao.fecharConexao(con, stmt, rs);
		}
		
		return lista;
		
	}

}
