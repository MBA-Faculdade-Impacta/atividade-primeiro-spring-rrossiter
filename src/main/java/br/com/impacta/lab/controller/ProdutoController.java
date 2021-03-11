package br.com.impacta.lab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	//http://localhost:8080/produtos
	public static List<Produto> bancoDeDados = new ArrayList<>();
	
	@PostMapping("lotes")
	public ResponseEntity<List<Produto>> criarProduto(@RequestBody List<Produto> produto) {
		bancoDeDados.addAll(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Produto>> consultarProdutos() {
		return ResponseEntity.ok(bancoDeDados);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> consultarProdutoPorId(@PathVariable("id") int id) {
		
		for (int contador = 0; contador < bancoDeDados.size(); contador++) {
			Produto produto = bancoDeDados.get(contador);
			if (produto.getId() == id) {
				return ResponseEntity.ok(produto);
			}
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> alterarStatusProduto(@PathVariable("id") int id,
			@RequestBody Produto newProduto) {
		
		for (int contador = 0; contador < bancoDeDados.size(); contador++) {
			Produto produto = bancoDeDados.get(contador);
			if (produto.getId() == id) {
				produto.setValor(newProduto.getValor());
        produto.setDescricao(newProduto.getDescricao());
				
				return ResponseEntity.ok(produto);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletarProduto(@PathVariable("id") int id) {
		
		for (int contador = 0; contador < bancoDeDados.size(); contador++) {
			Produto produto = bancoDeDados.get(contador);
			if (produto.getId() == id) {
				bancoDeDados.remove(contador);
				return ResponseEntity.ok(produto);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
}
