package com.generation.lojafarmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import com.generation.lojafarmacia.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto>findAllByNomeContainingIgnoreCase(@Param("nome")Long nome);
	public List<Produto>findAllByMarcaContainingIgnoreCase(@Param("marca")Long marca);
	public List<Produto>findByPreco(BigDecimal preco);
	public List<Produto>findByPrecoBetween(BigDecimal valor1, BigDecimal valor2);
	
}
