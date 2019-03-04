package br.com.eric.maven;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Product p = new Product("Laranja", 0.5d);
		System.out.println("Nome do produto: " + p.getName() + ", R$ " + p.getPrice());
	} 
}
