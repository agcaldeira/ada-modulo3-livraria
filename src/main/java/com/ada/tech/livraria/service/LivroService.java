package com.ada.tech.livraria.service;

import java.util.List;

import com.ada.tech.livraria.model.entity.Categoria;
import com.ada.tech.livraria.model.entity.Editora;
import com.ada.tech.livraria.model.entity.Livro;

public interface LivroService {
	
	void salvar(Livro livro);

	void editar(Livro livro);

	void excluir(Long id);

	Livro buscarPorId(Long id);

	List<Livro> buscarTodos();
	
	List<Livro> buscarPorCategoria(Categoria categoria);
	
	List<Livro> buscarPorEditora(Editora editora);
	
	List<Livro> buscarPorNomeOuIsbn(String nome, String isbn);

}
