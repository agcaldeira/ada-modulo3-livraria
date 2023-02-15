package com.ada.tech.livraria.service;

import java.util.List;

import com.ada.tech.livraria.model.entity.Categoria;

public interface CategoriaService {
	
	void salvar(Categoria categoria);

	void editar(Categoria categoria);

	void excluir(Long id);

	Categoria buscarPorId(Long id);

	List<Categoria> buscarTodos();

}
