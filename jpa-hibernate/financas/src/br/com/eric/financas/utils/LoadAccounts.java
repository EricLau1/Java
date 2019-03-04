package br.com.eric.financas.utils;

import javax.persistence.EntityManager;

import br.com.eric.financas.models.Account;

public class LoadAccounts {

	public LoadAccounts() {
			
		EntityManager em = JpaUtil.getEntityManager();
			
		Account acc1 = new Account("Jane Doe", "001", "Caixa", "112");
		Account acc2 = new Account("Jon Doe", "002", "Banco do Brasil", "223");
		Account acc3 = new Account("Ana", "003", "Santander", "334");
		Account acc4 = new Account("Mary", "004", "Itaú", "445");
		Account acc5 = new Account("Mark", "005", "Bradesco", "556");

		
		em.getTransaction().begin();
		em.persist(acc1);
		em.persist(acc2);
		em.persist(acc3);
		em.persist(acc4);
		em.persist(acc5);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
