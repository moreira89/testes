package br.com.rafaelmoreira.testes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmoreira.testes.model.Pessoa;
import br.com.rafaelmoreira.testes.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> recuperaPessoa(@PathVariable Long id){
		Pessoa p = pessoaService.recuperaPessoa(id);
		return ResponseEntity.ok(p);
	}
	
	
	@PostMapping
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) throws Exception{
		Pessoa p = pessoaService.cadastrarPessoa(pessoa);
		return ResponseEntity.ok().body(p);
	}
	
	
}
