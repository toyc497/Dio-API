package com.api.dioapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dioapi.entity.Produto;
import com.api.dioapi.service.ProdutoService;

@RestController
@RequestMapping("apidio")
public class ProdutoController{

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/salvaproduto")
	public ResponseEntity<Produto> salvaProduto(@RequestBody Produto product) throws Exception{
		
		return ResponseEntity.ok(produtoService.save(product));
		
	}
	
	@GetMapping("/produtoid/{id}")
	public ResponseEntity<Produto> produtoPeloID(@PathVariable("id") Long id) {
		
		Produto produto = produtoService.productFindById(id);
		return ResponseEntity.ok().body(produto);
		
	}
	
	@GetMapping("/allproducts")
	public ResponseEntity<List<Produto>> productFindAll(){
		
		List<Produto> produtos = produtoService.productFindAll();
		return ResponseEntity.ok().body(produtos);
		
	}
	
	@DeleteMapping("/produtodelete/{id}")
	public ResponseEntity<HttpStatus> produtoDelete(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(produtoService.productDeleteById(id));
		
	}
	
}
