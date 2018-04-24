package br.com.eric.main;

/* 
 * 
 * @Author: Eric Lau
 * 
 * Passos:
 * 
 * 1º Criar o banco de dados
 * 	
 * 	  Scripts na pasta SQL
 * 
 * 2º Download do driver do mysql connector j
 * 
 * 	  Configurar o mysql connector no Build Path
 * 
 * 3º Codifique...
 * 
 * */

import java.io.FileInputStream;

import br.com.eric.db.ImageDb;
import br.com.eric.model.Imagem;

public class JavaImageMySQL {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		try {

			String path = "C:\\Users\\eric\\eclipse-workspace\\JavaImageMySQL\\img\\img-1.jpg";
			
			Imagem img = new Imagem();
			
			String nome = "" + path.hashCode();
			
			nome += ".jpg";
			
			img.descricao = nome;
			img.imagem = new FileInputStream(path);
				
			if(ImageDb.create(img)) {
				System.out.println("Sucess!");
			}else {
				System.err.println("Failed...");
			} 
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	

}
