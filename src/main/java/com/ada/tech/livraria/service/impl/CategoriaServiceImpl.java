package com.ada.tech.livraria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ada.tech.livraria.model.entity.Categoria;
import com.ada.tech.livraria.repository.CategoriaRepository;
import com.ada.tech.livraria.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public void salvar(Categoria categoria) {
		repository.save(categoria);
	}

	@Override
	public void editar(Categoria categoria) {
		repository.save(categoria);
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Categoria buscarPorId(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Categoria> buscarTodos() {
		return repository.findAll();
	}
}
