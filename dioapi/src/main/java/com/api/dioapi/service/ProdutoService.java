package com.api.dioapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.dioapi.entity.Produto;
import com.api.dioapi.exception.ProductNullException;
import com.api.dioapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRespository;
	
	public Produto save(Produto product){
		
		if(product.getNome() == null || product.getPreco() == null || product.getDescricao() == null) {
			throw new ProductNullException();
		}
		
		return produtoRespository.save(product);
		
	}
	
	public Produto productFindById(Long id) {
		
		return produtoRespository.findById(id).orElse(null);
		
	}
	
	public List<Produto> productFindAll(){
		
		return produtoRespository.findAll();
		
	}

	public HttpStatus productDeleteById(Long id) {
		
		produtoRespository.deleteById(id);
		return HttpStatus.OK;
		
	}
	
}

