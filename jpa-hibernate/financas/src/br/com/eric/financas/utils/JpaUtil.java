package br.com.eric.financas.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
}
