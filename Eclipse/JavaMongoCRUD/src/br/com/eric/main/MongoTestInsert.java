package br.com.eric.main;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.eric.model.Produto;
import br.com.eric.model.Usuario;
import br.com.eric.mongodb.MongoConexao;

public class MongoTestInsert {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		// Declaração do Objeto de usuario
		Usuario user = new Usuario(
				1L, 
				"Jane Doe",
				LocalDate.now(),
				"jane@email.com",
				"qwert123",
				false
				);
		
		// Declaração dos objetos Produtos
		Produto p1 = new Produto(
				1L,
				"Notebook Dell",
				2500.75D,
				10,
				true
				);
		
		Produto p2 = new Produto(
				1L,
				"Placa de Video NVIDIA",
				3800D,
				10,
				true
				);
		
		Produto p3 = new Produto(
				1L,
				"Memória RAM",
				499.99D,
				0,
				false
				);
		
		// Preenchendo os documentos para o Insert no MongoDB
		
		// Documento para o produto 1
		Document dp1 = new Document("codigo", p1.getCodigo())
				.append("descricao", p1.getDescricao())
				.append("valor", p1.getValor())
				.append("quantidade", p1.getQuantidade())
				.append("disponivel", p1.getDisponivel());
		
		// Documento para o produto 2
		Document dp2 = new Document("codigo", p2.getCodigo())
				.append("descricao", p2.getDescricao())
				.append("valor", p2.getValor())
				.append("quantidade", p2.getQuantidade())
				.append("disponivel", p2.getDisponivel());
		
		// Documento para o produto 3
		Document dp3 = new Document("codigo", p3.getCodigo())
				.append("descricao", p3.getDescricao())
				.append("valor", p3.getValor())
				.append("quantidade", p3.getQuantidade())
				.append("disponivel", p3.getDisponivel());
		
		// Lista de Documentos
		List<Document> docList = new ArrayList<>();
		docList.add(dp1);
		docList.add(dp2);
		docList.add(dp3);
		
		Set<Document> produtos = new HashSet<>(docList);
		
		Document documento = new Document("id", user.getId())
				.append("nome", user.getNome())
				.append("nascimento", user.getNascimento())
				.append("email", user.getEmail())
				.append("senha", user.getSenha())
				.append("online", user.getOnline())
				.append("vendas", produtos);
		
		MongoDatabase db = MongoConexao.getMongoConexao();
		
		MongoCollection colecao = db.getCollection("usuarios");
		
		colecao.insertOne(documento);
			
		Usuario u = new Usuario();
		u.setId(10000L);
		u.setNome("Jon Doe");
		u.setNascimento(LocalDate.of(1991, Month.OCTOBER, 29));
		u.setEmail("jon@email.com");
		u.setSenha("a65sd4a65sd4a65s4");
		u.setOnline(true);
		
		Set<Double> apostas = new HashSet<>();
		apostas.add(100.43D);
		apostas.add(500.19D);
		apostas.add(1500.85D);
		apostas.add(8500.97D);
		
		Document doc = new Document("id", u.getId())
				.append("nome", u.getNome())
				.append("nascimento", u.getNascimento())
				.append("email", u.getEmail())
				.append("senha", u.getSenha())
				.append("online", u.getOnline())
				.append("apostas", apostas);
	
		colecao.insertOne(doc);
	
		System.out.println("Insert realizado com sucesso!");

	}

}
