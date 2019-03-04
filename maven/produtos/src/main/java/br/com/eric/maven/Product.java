package br.com.eric.maven;

public class Product {

	private String name;
	private double price;
	
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getPriceWithTax() {
		return price * (10 / 100);
	}
}
