package com.generation.lojafarmacia.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo grupo é obrigatório e não pode conter espaços em branco")
	@Size(min = 1, max = 100, message = "O atributo grupo deve conter no mínimo 5 e no máximo 100 caracteres...")
	private String grupo;
	
	@NotBlank(message = "O atributo data de vencimento é obrigatório e não pode conter espaços em branco")
	@Size(min = 1, max = 100, message = "O atributo vencimento deve conter no mínimo 5 e no máximo 100 caracteres...")
	private String data_Vencimento;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getGrupo() {
		return grupo;
	}
	
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public String getData_Vencimento() {
		return data_Vencimento;
	}
	
	public void setData_Vencimento(String data_Vencimento) {
		this.data_Vencimento = data_Vencimento;
	}
}