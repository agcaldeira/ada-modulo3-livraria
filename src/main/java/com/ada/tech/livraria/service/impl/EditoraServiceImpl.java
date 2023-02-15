package com.ada.tech.livraria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ada.tech.livraria.model.entity.Editora;
import com.ada.tech.livraria.repository.EditoraRepository;
import com.ada.tech.livraria.service.EditoraService;

public class EditoraServiceImpl implements EditoraService {

	@Autowired
	private EditoraRepository repository;
	
	@Override
	public void salvar(Editora editora) {
		repository.save(editora);
	}

	@Override
	public void editar(Editora editora) {
		repository.save(editora);
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Editora buscarPorId(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Editora> buscarTodos() {
		return repository.findAll();
	}

}
