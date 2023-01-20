package com.montaldi.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montaldi.projeto.entities.Product;
import com.montaldi.projeto.services.ProductService;

@RestController 
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	// # EndPoint para retornar todos usuários da base de dados.
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	// # EndPoint para retornar usuário da base de dados pelo Id.
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	
	
}
