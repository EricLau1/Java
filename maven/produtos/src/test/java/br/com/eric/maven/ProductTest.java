package br.com.eric.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest {

	@Test
	public void verifyPriceWithTax() {
		Product laranja = new Product("Laranja", 0.75);
		double priceTax = (10 /100) * laranja.getPrice();
		assertEquals(priceTax, laranja.getPriceWithTax(), 0.00001);
	}

}
