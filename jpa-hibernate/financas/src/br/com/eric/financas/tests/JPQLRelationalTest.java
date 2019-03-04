package br.com.eric.financas.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.eric.financas.models.Category;
import br.com.eric.financas.models.Movement;
import br.com.eric.financas.utils.JpaUtil;

public class JPQLRelationalTest {

	public static void main(String[] args) {
		findMovementByCategory();
		System.exit(0);
	}
	
	public static void findMovementByCategory() {
		
		Category category = new Category();
		category.setId(1);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		// query baseada nas classes
		String jpql = "select m from Movement m join m.categories c where c = :category";
		
		Query query = em.createQuery(jpql);
		query.setParameter("category", category);
		
		List<Movement> results = query.getResultList();
		
		for(Movement movement: results) {
			System.out.print("Descrição: " + 
					movement.getDescription() + ", Conta: " + 
					movement.getAccount().getId() + ", R$ " + 
					movement.getValue());
			if (movement.getCategories().size() > 0 ) {
				System.out.print(", Categorias: ");
				for(Category c: movement.getCategories()) {
					System.out.print( c.getName() + ", ");
				}
				System.out.println("");
			} 
		}
		
		em.getTransaction().commit();
		em.close();
	
	}
}
