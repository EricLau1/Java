package br.com.eric.mongodb;

/* 
 * Author: Eric Lau 02/05/2018 16H06min
 * 
 * Download MongoDB: https://www.mongodb.com/
 * 
 * Pós Instalação:
 * 
 * Crie um diretorio chamado "data" no Disco Local C:
 * 
 * Execute o servidor na pasta de instalação "mongod.exe"
 * 
 * Aponte o build path para o driver na pasta "lib"
 *
 * 
 * Lets Code!
 * 
 * 
 * */

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

public class MongoConexao {
	
	private static MongoClient mongoCliente = null;
	
	private static final String HOST = "localhost";
	private static final int PORTA = 27017;
	
	private static final String NOME_BANCO = "test";
	
	public static boolean conectado = false;
	
	public static MongoDatabase getMongoConexao() {
		
		MongoDatabase db = null;
		
		try {
			
			mongoCliente = new MongoClient(HOST, PORTA);
			
			conectado = true;
			
			System.out.println("MongoDB conectado.");
			
			db = mongoCliente.getDatabase(NOME_BANCO);
			
			System.out.println("Banco de dados selecionado:\"" + db.getName() + "\"");
			
			
		} catch (MongoException ex) {
			System.err.println("Erro ao conectar...\nErr: " + ex.getMessage());
		}
		
		return db;
	}
	
}
