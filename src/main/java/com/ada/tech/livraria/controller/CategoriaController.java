package com.ada.tech.livraria.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ada.tech.livraria.model.entity.Categoria;
import com.ada.tech.livraria.service.CategoriaService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarUm(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(service.buscarPorId(id));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
		try {
			service.salvar(categoria);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping()
	public ResponseEntity<Categoria> editar(@RequestBody Categoria categoria) {
		try {
			service.editar(categoria);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Categoria> remover(@PathVariable("id") Long id) {
        try {
        	service.excluir(id);
        	return ResponseEntity.status(HttpStatus.OK).build();
        }catch(EntityNotFoundException ex) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
