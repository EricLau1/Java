package com.products.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST produtos")
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Product> getProducts() {
		return this.productRepository.findAllByOrderByIdAsc();
	}
	
	@GetMapping("/products/{id}")
	@ApiOperation(value="Retorna um produto pelo ID")
	public Product getProduct(@PathVariable(value="id") long id) {
		return this.productRepository.findById(id);	
	}
	
	@PostMapping("/products")
	@ApiOperation(value="Salva o produto no banco de dados")
	public ResponseEntity<Product> postProduct(@RequestBody Product product) {
		Product responseProduct;
		responseProduct = productRepository.save(product);
		return new ResponseEntity<>(responseProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/products/{id}")
	@ApiOperation(value="Atualiza um produto pelo ID")
	public Product putProduct(@RequestBody Product product, @PathVariable(value="id") long id) {
		product.setId(id);
		return this.productRepository.save(product);
	}
	
	@DeleteMapping("/products/{id}")
	@ApiOperation(value="Deleta um produto pelo ID")
	public ResponseEntity<Void> deleteProduct(@PathVariable(value="id") long id) {
		this.productRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);	
	}
}
