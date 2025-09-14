package com.farmacia.demofarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farmacia.demofarmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
