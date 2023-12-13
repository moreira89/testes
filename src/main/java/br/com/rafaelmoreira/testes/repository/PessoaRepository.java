package br.com.rafaelmoreira.testes.repository;

import org.springframework.stereotype.Component;

import br.com.rafaelmoreira.testes.model.Pessoa;

@Component
public class PessoaRepository {

	public Pessoa cadastrar(Pessoa pessoa) {
		//cadastra no banco
		return pessoa;
	}
	
}
