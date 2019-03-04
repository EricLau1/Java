package br.com.eric.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovementDao {
	
	private EntityManager em = null;
	
	public MovementDao(EntityManager em) {
		this.em = em;
	}

	public List<Double> getAvgs() {
		// query baseada nas classes
		String jpql = "select avg(m.value) from Movement m " +
		" group by day(m.date), month(m.date), year(m.date)";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		
		return query.getResultList();
	}
}
