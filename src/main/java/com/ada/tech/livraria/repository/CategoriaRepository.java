package com.ada.tech.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.tech.livraria.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
