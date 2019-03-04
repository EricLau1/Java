package br.com.eric.financas.tests;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.models.Movement;
import br.com.eric.financas.models.MovementType;
import br.com.eric.financas.utils.JpaUtil;

public class JpaRelationalTest {

	public static void main(String[] args) {
		
		Account acc = new Account("Miranda", "010", "Santander", "667");
		
		Movement m = new Movement();
		m.setDate(Calendar.getInstance());
		m.setDescription("Fast Food");
		m.setType(MovementType.DEBIT);
		m.setValue(new BigDecimal("80.0"));
		m.setAccount(acc);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(acc);
		em.persist(m);
		
		em.getTransaction().commit();
		em.close();
	}
}
