package br.com.eric.financas.tests;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.models.Category;
import br.com.eric.financas.models.Movement;
import br.com.eric.financas.models.MovementType;
import br.com.eric.financas.utils.JpaUtil;

public class MovementCategoryTest {

	public static void main(String[] args) {
		
		Category c1 = new Category("Viagem");
		Category c2 = new Category("Negócios");
		
		Account account = new Account();
		account.setId(2);
		
		Movement m1 = new Movement();
		m1.setValue(new BigDecimal("100.0"));
		m1.setType(MovementType.DEBIT);
		m1.setDate(Calendar.getInstance());
		m1.setDescription("Viagem `a SP");
		m1.setCategories(Arrays.asList(c1, c2));
		
		m1.setAccount(account);
		
		Movement m2 = new Movement();
		
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		
		m2.setValue(new BigDecimal("5500.0"));
		m2.setType(MovementType.CREDIT);
		m2.setDate(tomorrow);
		m2.setDescription("Viagem `a Nova York");
		m2.setCategories(Arrays.asList(c1, c2));
		
		m2.setAccount(account);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		account = em.find(Account.class, account.getId());
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(m1);
		em.persist(m2);
		
		em.getTransaction().commit();
		em.close();
		
		System.exit(0);
		
	}
}
