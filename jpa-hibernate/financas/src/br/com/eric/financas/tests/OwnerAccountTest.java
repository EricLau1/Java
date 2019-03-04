package br.com.eric.financas.tests;

import javax.persistence.EntityManager;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.models.Owner;
import br.com.eric.financas.utils.JpaUtil;

public class OwnerAccountTest {

	public static void main(String[] args) {
		
		Owner owner = new Owner();
		owner.setName("Bruce Wayne");
		owner.setAddress("Gotham City");
		owner.setJob("Empresário");
		
		Account account = new Account();
		account.setId(2);
		
		owner.setAccount(account);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(owner);
		
		em.getTransaction().commit();
		em.close();
	}
}
