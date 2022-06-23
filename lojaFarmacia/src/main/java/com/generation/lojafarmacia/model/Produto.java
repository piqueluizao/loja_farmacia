package com.generation.lojafarmacia.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")

public class Produto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 5 e no máximo 100 caracteres...")
	private String nome;
	
	@NotNull(message = "O atributo preço é obrigatório e não pode utilizar espaços em branco!")
	private BigDecimal preco;
	
	@NotBlank(message = "O atributo descrição é obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 05, max = 4000, message = "O atributo descrição deve conter no mínimo 100 e no máximo 7000 caracteres...")
	private String descricao;
	
	@NotNull(message = "O atributo marca é obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 05, max = 100, message = "O atributo marca deve conter no mínimo 05 e no máximo 100 caracteres...")
	private String marca;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco( BigDecimal preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}