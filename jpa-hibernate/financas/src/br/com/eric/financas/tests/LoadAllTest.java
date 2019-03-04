package br.com.eric.financas.tests;

import br.com.eric.financas.utils.LoadAccounts;
import br.com.eric.financas.utils.LoadMovements;

public class LoadAllTest {

	public static void main(String[] args) {
		
		new LoadAccounts();
		new LoadMovements();
		
		System.exit(0);
	}
	
}
