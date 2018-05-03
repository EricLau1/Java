package br.com.eric.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.eric.model.Usuario;
import br.com.eric.mongodb.MongoConexao;

public class MongoTestRead {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
						
		MongoDatabase db = MongoConexao.getMongoConexao();
		
		MongoCollection<Document> colecao = db.getCollection("usuarios");
		
		Document busca = new Document("id", 10000L);
		
		MongoCursor<Document> iterador = colecao.find(busca).iterator();
		
		Usuario u = new Usuario();
		
		List<Double> valores = new ArrayList<>();
		
		try {
			
			while(iterador.hasNext()) {
				
				Document doc = iterador.next();
				
				u.setId(doc.getLong("id"));
				u.setNome(doc.getString("nome"));
				u.setNascimento(LocalDate.now());
				u.setEmail(doc.getString("email"));
				u.setSenha(doc.getString("senha"));
				u.setOnline(doc.getBoolean("online", false));
				
				valores = doc.get("apostas", List.class);
			}
			
			System.out.println("Documento lido com sucesso!");
			
			System.out.println("Usuario: " + u.getNome());
			System.out.println("Qtd. apostas: " + valores.size());
			System.out.print("Valores: ");
			
			for(int i = 0; i < valores.size(); i++) {
				
				if (i < valores.size() - 1) {
					System.out.print(valores.get(i) + ", ");		
				}
				else {
					System.out.print(valores.get(i));
					
				}
			}
			
		} catch(MongoException ex) {
			System.err.println("Erro ao ler documento...\nErr: " + ex.getMessage());
		}
	}

}
