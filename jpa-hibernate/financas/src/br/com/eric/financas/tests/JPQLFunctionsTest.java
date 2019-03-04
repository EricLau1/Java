package br.com.eric.financas.tests;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.eric.financas.dao.MovementDao;
import br.com.eric.financas.models.Account;
import br.com.eric.financas.models.MovementType;
import br.com.eric.financas.utils.JpaUtil;

public class JPQLFunctionsTest {
	
	public static void main(String[] args) {
		
		sum();
		avg();
		namedQueryTest();
		avgGroupByDate();
		movementDaoTest();
		
		System.exit(0);
		
	}
	
	public static void sum() {
		Account account = new Account();
		account.setId(5);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select sum(m.value) from Movement m where m.account = :account " + 
		" and m.type = :type" +
		" order by m.value desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("account", account);
		query.setParameter("type", MovementType.CREDIT);
		
		BigDecimal sum = (BigDecimal) query.getSingleResult();
		
		System.out.println("Total depositado: " + sum);
		
		em.getTransaction().commit();
		em.close();
	}

	public static void avg() {
		Account account = new Account();
		account.setId(5);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select avg(m.value) from Movement m where m.account = :account " + 
		" and m.type = :type" +
		" order by m.value desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("account", account);
		query.setParameter("type", MovementType.CREDIT);
		
		Double avg = (Double) query.getSingleResult();
		
		System.out.println("Média dos valores depositados: " + avg);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void avgGroupByDate() {
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select avg(m.value) from Movement m " +
		" group by day(m.date), month(m.date), year(m.date)";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		
		List<Double> avgs = (List<Double>) query.getResultList();
		
		System.out.println("Media de valores do dia 4: " + avgs.get(0));
		System.out.println("Media de valores do dia 5: " + avgs.get(1));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void namedQueryTest() {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Double> query = em.createNamedQuery("allAvgs", Double.class); // named query definido na classe Movement
		
		List<Double> avgs = (List<Double>) query.getResultList();
		
		System.out.println("Media de valores do dia 4: " + avgs.get(0));
		System.out.println("Media de valores do dia 5: " + avgs.get(1));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void movementDaoTest() {
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		MovementDao dao = new MovementDao(em);
		
		List<Double> avgs = dao.getAvgs();
		
		System.out.println("Media de valores do dia 4: " + avgs.get(0));
		System.out.println("Media de valores do dia 5: " + avgs.get(1));
		
		em.getTransaction().commit();
		em.close();
	}
}
