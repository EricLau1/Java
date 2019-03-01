package com.products.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{ // <- é necessário informa o tipo da Entitidade e o tipo do Id dessa entidade
	
	public Product findById(long id);
	// retorna a lista ordenada em ordem ascendente pelo Id
	public List<Product> findAllByOrderByIdAsc();
	// retorna os primeiros 10 itens lista ordenada em ordem ascendente pelo Id
	public List<Product> findTop10ByOrderByIdAsc();
	
}
