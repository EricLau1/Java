package br.com.eric.financas.tests;

import javax.persistence.EntityManager;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.models.Movement;
import br.com.eric.financas.utils.JpaUtil;

public class AccountMovementTest {

	public static void main(String[] args) {
		
		findAccountByMovement();
		
		System.exit(0);
	}
	
	public static void findAccountByMovement() {
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		Movement m = em.find(Movement.class, 4);
		
		Account acc = m.getAccount();
		
		System.out.println("Dono da conta: " + acc.getOwner());
		System.out.println("Movimentações: " + acc.getMovements().size());
				
		em.getTransaction().commit();
		em.close();
		

	}
}
