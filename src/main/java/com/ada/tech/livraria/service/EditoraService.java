package com.ada.tech.livraria.service;

import java.util.List;

import com.ada.tech.livraria.model.entity.Editora;

public interface EditoraService {
	
	void salvar(Editora editora);

	void editar(Editora editora);

	void excluir(Long id);

	Editora buscarPorId(Long id);

	List<Editora> buscarTodos();

}
