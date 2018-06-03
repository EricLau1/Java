package br.com.eric.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.eric.db.Conexao;
import br.com.eric.model.Produto;

public class TestProcedure {
	
	public static void main(String[] args) {
		
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		String sql = "CALL `test`.`find_produto`( ? )";
		
		String busca = "%ba%";
		
		List<Produto> produtos = new ArrayList<>();
		
		try {
			
			con = Conexao.conectar();
			cs = con.prepareCall(sql);
			cs.setString(1, busca);
			
			rs = cs.executeQuery();
			
			while(rs.next()) {
				
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setDescricao(rs.getString("descricao"));
				p.setValor(rs.getDouble("valor"));
				
				String data = rs.getTimestamp("data_registro")
						.toLocalDateTime() + "";
				
				p.setDataRegistro(LocalDateTime.parse(data));
			
				produtos.add(p);
			}
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		
		} finally {
		
			Conexao.fechar(con, cs, rs);
		
		}
		
		for(int i = 0; i < produtos.size(); i++) {
			System.out.println(produtos.get(i).toString());
		}
		
	}

}
