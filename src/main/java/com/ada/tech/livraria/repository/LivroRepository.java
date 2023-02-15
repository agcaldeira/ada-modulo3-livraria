package com.ada.tech.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ada.tech.livraria.model.entity.Categoria;
import com.ada.tech.livraria.model.entity.Editora;
import com.ada.tech.livraria.model.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	@Query("select l from livro l where l.categoria = :categoria")
	List<Livro> findByCategoria(@Param("categoria") Categoria categoria);

	@Query("select l from livro l where l.editora = :editora")
	List<Livro> findByEditora(@Param("editora") Editora editora);
	
}