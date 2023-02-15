package com.ada.tech.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ada.tech.livraria.model.entity.Categoria;
import com.ada.tech.livraria.model.entity.Editora;
import com.ada.tech.livraria.model.entity.Livro;
import com.ada.tech.livraria.service.LivroService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/Livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarUm(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(service.buscarPorId(id));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping
	public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
		try {
			service.salvar(livro);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping()
	public ResponseEntity<Livro> editar(@RequestBody Livro livro) {
		try {
			service.editar(livro);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Livro> remover(@PathVariable("id") Long id) {
        try {
        	service.excluir(id);
        	return ResponseEntity.status(HttpStatus.OK).build();
        }catch(EntityNotFoundException ex) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	@GetMapping("/buscarPorCategoria")
    public ResponseEntity<List<Livro>> buscarPorCategoria(@RequestBody Categoria categoria) {
        try {
            return ResponseEntity.ok(service.buscarPorCategoria(categoria));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	@GetMapping("/buscarPorEditora")
    public ResponseEntity<List<Livro>> buscarPorEditora(@RequestBody Editora editora) {
        try {
            return ResponseEntity.ok(service.buscarPorEditora(editora));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	 @GetMapping("/nomeOuIsbn")
	    public ResponseEntity<List<Livro>> buscarPorNomeOuIsbn(@RequestParam(value = "nome", required = false) String nome,
	                                                           @RequestParam(value = "isbn", required = false) String isbn) {
	        try {
	            return ResponseEntity.ok(service.buscarPorNomeOuIsbn(nome, isbn));
	        } catch (EntityNotFoundException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        } catch (Exception ex) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
	    }


}
