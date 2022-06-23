package com.generation.lojafarmacia.repository;

import java.util.List;

import com.generation.lojafarmacia.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List <Categoria> findAllByGrupoContainingIgnoreCase (@Param("grupo")Long grupo);

}
