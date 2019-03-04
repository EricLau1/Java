package br.com.eric.financas.utils;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.eric.financas.models.Account;
import br.com.eric.financas.models.Movement;
import br.com.eric.financas.models.MovementType;

public class LoadMovements {
	
	public LoadMovements() {
		
		Account acc = new Account();
		acc.setId(4);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		Movement m1 = new Movement();
		m1.setDate(Calendar.getInstance());
		m1.setDescription("Viagem ao Rio Grande do Sul");
		m1.setType(MovementType.DEBIT);
		m1.setValue(new BigDecimal("280.0"));
		m1.setAccount(acc);
		
		Movement m2 = new Movement();
		m2.setDate(Calendar.getInstance());
		m2.setDescription("Depósito bancário");
		m2.setType(MovementType.CREDIT);
		m2.setValue(new BigDecimal("1000.0"));
		m2.setAccount(acc);
		
		acc.setId(5);
		
		Movement m3 = new Movement();
		m3.setDate(Calendar.getInstance());
		m3.setDescription("Carro vendido");
		m3.setType(MovementType.CREDIT);
		m3.setValue(new BigDecimal("18750.0"));
		m3.setAccount(acc);
		
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		
		em.getTransaction().commit();
		em.close();
	}
}
