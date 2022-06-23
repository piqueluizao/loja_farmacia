package com.generation.lojafarmacia.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojafarmacia.model.Produto;
import com.generation.lojafarmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

@Autowired
private ProdutoRepository produtoRepository;
 
@GetMapping
public ResponseEntity<List<Produto>> getAll(){
	return ResponseEntity.ok(produtoRepository.findAll());
} 

@GetMapping("/{id}")
public ResponseEntity<Produto> getById(@PathVariable Long id){
	return ( produtoRepository.findById (id))
			.map (resposta-> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
}

@GetMapping("/nome/{nome}")
public ResponseEntity<List<Produto>>getByNome(@PathVariable Long nome){
	return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));	
}

@GetMapping("/marca/{marca}")
public ResponseEntity<List<Produto>>getByMarca(@PathVariable Long marca){
	return ResponseEntity.ok(produtoRepository.findAllByMarcaContainingIgnoreCase(marca));	
}

@GetMapping("/preco/{preco}")
public ResponseEntity<List<Produto>>getByPreco(@PathVariable BigDecimal preco){
	return ResponseEntity.ok(produtoRepository.findByPreco(preco));	
}

@GetMapping("preco/{valor1}a{valor2}")
public ResponseEntity<List<Produto>> getByPreco(@PathVariable BigDecimal valor1, @PathVariable BigDecimal valor2){
	return ResponseEntity.ok(produtoRepository.findByPrecoBetween(valor1, valor2));
	 
}

@PostMapping
public ResponseEntity<Produto>postProduto (@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
}

@PutMapping
public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
	return produtoRepository.findById(id)
			.map(resposta->{
				produtoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			})
			.orElse(ResponseEntity.notFound().build());
}
}
