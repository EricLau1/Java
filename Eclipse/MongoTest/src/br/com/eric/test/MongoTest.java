package br.com.eric.test;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/*
 * Download do Mongo Java Driver:
 * 
 * 	https://oss.sonatype.org/content/repositories/releases/org/mongodb/mongo-java-driver/3.6.3/
 * 
 * 
 * @Author: Eric Lau de Oliveira
 * 
 * 			26/03/2018
 * 
 * */

public class MongoTest {
	
	public static void main(String[] args) {
	
		
		MongoClient mc = null;
		
		try {
			
			mc = new MongoClient("localhost", 27017);
			
			System.out.println("Conexão realizada com sucesso!");
			
			MongoDatabase db = mc.getDatabase("mongotest");
			
			System.out.println("Base de dados selecionada: " + db.getName());
			
			MongoCollection<Document> colecao = db.getCollection("usuarios");
			
			MongoCursor<Document> iterator = colecao.find().iterator();
			
			while(iterator.hasNext()) {
				Document doc = iterator.next();
				System.out.println("Nome: " + doc.getString("nome"));
				System.out.println("Idade: " + doc.getInteger("idade"));
				System.out.println("Curso: " + doc.getString("curso"));
				
				bar('*', 25);
			}
			
		} catch (Exception ex) {
			System.err.println("Erro: " + ex.getMessage());
		}
		
		mc.close();
	}
	
	public static void bar(final char SYMBOL, final int SIZE) {
		System.out.println("");
		for(int i = 0; i < SIZE; i++) {
			System.out.print(SYMBOL);
		}
		System.out.println("");
	}
}
