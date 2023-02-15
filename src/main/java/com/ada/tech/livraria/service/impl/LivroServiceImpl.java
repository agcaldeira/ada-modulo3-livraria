package com.ada.tech.livraria.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ada.tech.livraria.model.entity.Categoria;
import com.ada.tech.livraria.model.entity.Editora;
import com.ada.tech.livraria.model.entity.Livro;
import com.ada.tech.livraria.repository.LivroRepository;
import com.ada.tech.livraria.service.LivroService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class LivroServiceImpl implements LivroService {
	
	@PersistenceContext
    private EntityManager em;

	@Autowired
	private LivroRepository repository;
	
	@Override
	public void salvar(Livro livro) {
		repository.save(livro);
	}

	@Override
	public void editar(Livro livro) {
		repository.save(livro);
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Livro buscarPorId(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Livro> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public List<Livro> buscarPorCategoria(Categoria categoria) {
		return repository.findByCategoria(categoria);
	}

	@Override
	public List<Livro> buscarPorEditora(Editora editora) {
		return repository.findByEditora(editora);
	}
	
    @Override
    public List<Livro> buscarPorNomeOuIsbn(String nome, String isbn) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);
        Root<Livro> root = cq.from(Livro.class);

        List<Predicate> predicates = new ArrayList<>();

        if (!nome.isEmpty()) {
            predicates.add(cb.like(root.get("nome"), "%" + nome + "%"));
        }

        if (!isbn.isEmpty()) {
            predicates.add(cb.like(root.get("isbn"), "%" + isbn + "%"));
        }

        cq.where(cb.or(predicates.toArray(new Predicate[0])));

        return em.createQuery(cq).getResultList();
    }

}
