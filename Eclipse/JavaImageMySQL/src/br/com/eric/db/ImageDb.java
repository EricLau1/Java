package br.com.eric.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.eric.model.Imagem;

public class ImageDb {
	
	@SuppressWarnings("static-access")
	public static boolean create(Imagem img) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_images (descricao, imagem) VALUES (?, ?)";
		
		try {
			
			con = Conexao.getConexao();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, img.descricao);
			stmt.setBinaryStream(2, img.imagem);
			stmt.executeUpdate();
			
			System.out.println("um item foi salvo no banco de dados.");
		
			return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			Conexao.fecharConexao(con, stmt);
		}
		
		return false;
		
	}
	
	@SuppressWarnings("static-access")
	public static List<Imagem> find() {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_images";
		
		List<Imagem> imagens = new ArrayList<>();
		
		try {
			
			con = Conexao.getConexao();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Imagem img = new Imagem();
				img.id = rs.getLong("id");
				img.descricao = rs.getString("descricao");
				img.imgBytes = rs.getBytes("imagem");
				
				imagens.add(img);
				
			}
			
			System.out.println("Lista de imagens completa");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			Conexao.fecharConexao(con, stmt, rs);
		}
		
		return imagens;
	}
	
}
