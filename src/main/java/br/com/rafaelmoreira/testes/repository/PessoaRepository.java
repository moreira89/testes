package br.com.rafaelmoreira.testes.repository;

import org.springframework.stereotype.Component;

import br.com.rafaelmoreira.testes.model.Pessoa;

@Component
public class PessoaRepository {

	public Pessoa cadastrar(Pessoa pessoa) {
		//cadastra no banco
		pessoa.setId(1L);
		return pessoa;
	}

	public Pessoa findById(Long id) {
		return Pessoa.builder()
						.id(1L)
						.nome("Rafael")
						.email("rafael@email.com.br")
						.idade(34)
					.build();
		
	}
	
}
