package br.com.eric.main;

import com.mongodb.client.MongoDatabase;

import br.com.eric.mongodb.MongoConexao;

public class MongoDbTest {

	
	public static void main(String[] args) {
		
		MongoDatabase md = MongoConexao.getMongoConexao();
		
		if(MongoConexao.conectado) {
			
			System.out.println(md.toString());
			
		} else {
			System.out.println("...");
		}
		
	}
}
