package com.api.dioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dioapi.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
