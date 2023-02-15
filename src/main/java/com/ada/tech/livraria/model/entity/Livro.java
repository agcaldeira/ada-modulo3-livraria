package com.ada.tech.livraria.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nome", nullable=false, length = 100)
	private String nome;
	
	@Column(name="isbn", length = 13)
	private String isbn;
	
	@ManyToOne
	@JoinColumn(name = "editora_id", nullable = false)
	private Editora editora;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
	
}
