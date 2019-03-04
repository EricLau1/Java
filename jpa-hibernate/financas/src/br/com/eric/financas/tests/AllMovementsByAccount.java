package br.com.eric.financas.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.utils.JpaUtil;

public class AllMovementsByAccount {

	public static void main(String[] args) {
		findAccountMovementsJoin();
		findAccountDistinctMovementsJoin();
		findAccountDistinctMovementsLeftJoin();
	}
	
	public static void findAccountMovementsJoin() {

		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// junta a conta e a movimentação, e não aplica o lazy loading ao buscar recursos
		String jpql = "select a from Account a join fetch a.movements"; 
		
		Query query = em.createQuery(jpql);
		
		List<Account> accounts = query.getResultList();
		
		for(Account acc: accounts) {
			System.out.println("===================================");
			System.out.println("Dono da conta: " + acc.getOwner());
			System.out.println("Movimentações: ");
			System.out.println(acc.getMovements().size());
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void findAccountDistinctMovementsJoin() {

		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// junta a conta e a movimentação, e não aplica o lazy loading ao buscar recursos
		String jpql = "select distinct a from Account a join fetch a.movements"; 
		
		Query query = em.createQuery(jpql);
		
		List<Account> accounts = query.getResultList();
		
		for(Account acc: accounts) {
			System.out.println("===================================");
			System.out.println("Dono da conta: " + acc.getOwner());
			System.out.println("Movimentações: ");
			System.out.println(acc.getMovements().size());
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void findAccountDistinctMovementsLeftJoin() {

		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// junta a conta e a movimentação, e não aplica o lazy loading ao buscar recursos
		String jpql = "select distinct a from Account a left join fetch a.movements"; 
		
		Query query = em.createQuery(jpql);
		
		List<Account> accounts = query.getResultList();
		
		for(Account acc: accounts) {
			System.out.println("===================================");
			System.out.println("Dono da conta: " + acc.getOwner());
			System.out.println("Movimentações: ");
			System.out.println(acc.getMovements().size());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
