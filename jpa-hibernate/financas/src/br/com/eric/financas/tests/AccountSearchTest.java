package br.com.eric.financas.tests;

import javax.persistence.EntityManager;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.utils.JpaUtil;

public class AccountSearchTest {

	public static void main(String[] args) {
		
		AccountSearchTest ast = new AccountSearchTest();
		ast.findByIdTest();
		ast.accountDetachedToManagedTest();
		//ast.removeAccount();
	}
	
	public void findByIdTest() {
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		Account acc = em.find(Account.class, 1);
		
		/* 
		 * Caso algum atributo seja mudado nesta parte,
		 * as informações no banco de dados também serão atualizadas
		 * 
		 * Exemplo:
		 * 
		 * 		acc.setOwner("Emma");
		 * 
		 * */
		acc.setOwner("Emma");
		
		em.getTransaction().commit();
		em.close();
		System.out.println("Dono da conta: " + acc.getOwner());
	}
	
	public void accountDetachedToManagedTest() {
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		Account acc = em.find(Account.class, 1);

		acc.setOwner("Milly");
		
		em.getTransaction().commit();
		em.close();
		// Fim do estado managed, ou seja, fim da sincronização com o banco
		
		// O objeto 'acc' está em estado 'detached'
		
		EntityManager em2 = JpaUtil.getEntityManager();
		em2.getTransaction().begin();
	
		acc.setOwner("Samantha");
		em2.merge(acc); // passa para o estado menaged, agora as informações estão sincronizadas
		
		em2.getTransaction().commit();
		em2.close();
		
		System.out.println("Dono da conta: " + acc.getOwner());
	}
	
	public void removeAccount() {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		Account acc = em.find(Account.class, 5);
		
		em.remove(acc);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
