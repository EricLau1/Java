package br.com.eric.financas.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.models.Movement;
import br.com.eric.financas.models.MovementType;
import br.com.eric.financas.utils.JpaUtil;

public class JPQLTest {

	public static void main(String[] args) {
	
		jpqlFindByAccount();
		jpqlFindByAccountOrderByValueDesc();
		jpqlFindWhereAccountIdAndMovementType();
		
		System.exit(0);
	}
	
	public static void jpqlFindByIdAccount() {
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select m from Movement m where m.account.id = 2";
		
		Query query = em.createQuery(jpql);
		
		List<Movement> results = query.getResultList();
		
		for(Movement movement: results) {
			System.out.println("Descrição: " + movement.getDescription());
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void jpqlFindByAccount() {
		
		Account account = new Account();
		account.setId(2);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select m from Movement m where m.account = :account";
		
		Query query = em.createQuery(jpql);
		query.setParameter("account", account);
		
		List<Movement> results = query.getResultList();
		
		for(Movement movement: results) {
			System.out.println("Descrição: " + 
					movement.getDescription() + ", Conta: " + 
					movement.getAccount().getId() + ", R$ " + movement.getValue());
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void jpqlFindByAccountOrderByValueDesc() {
		
		Account account = new Account();
		account.setId(2);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select m from Movement m where m.account = :account order by m.value desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("account", account);
		
		List<Movement> results = query.getResultList();
		
		for(Movement movement: results) {
			System.out.println("Descrição: " + movement.getDescription() + 
					", Conta: " + movement.getAccount().getId() +
					", R$ " + movement.getValue());
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void jpqlFindWhereAccountIdAndMovementType() {
		Account account = new Account();
		account.setId(2);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select m from Movement m where m.account = :account " + 
		" and m.type = :type" +
		" order by m.value desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("account", account);
		query.setParameter("type", MovementType.DEBIT);
		
		List<Movement> results = query.getResultList();
		
		for(Movement movement: results) {
			System.out.println("Descrição: " + movement.getDescription() + 
					", Conta: " + movement.getAccount().getId() +
					", R$ " + movement.getValue());
		}
		
		em.getTransaction().commit();
		em.close();	
	}
}
