package br.com.rafaelmoreira.testes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmoreira.testes.model.Pessoa;
import br.com.rafaelmoreira.testes.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	public Pessoa cadastrarPessoa(Pessoa pessoa) throws Exception {
		
		if (pessoa == null) {
			throw new Exception("Nenhuma informação foi passada");
		}
		
		if (pessoa.getNome() == null || pessoa.getNome().isBlank() || pessoa.getNome().isEmpty()) {
			throw new Exception("Nome da pessoa deve ser informado");
		}
		
		if (pessoa.getEmail() == null || pessoa.getEmail().isBlank() || pessoa.getEmail().isEmpty()) {
			throw new Exception("Email da pessoa deve ser informado");
		}
		
		if (pessoa.getIdade() == null) {
			throw new Exception("Idade da pessoa deve ser informado");
		}
		
		if (pessoa.getIdade() < 1) {
			throw new Exception("Idade incorreta");
		}
		
		if (pessoa.getIdade() < 18) {
			throw new Exception("Não é permitido entrada de menores de idade");
		}
		
		return pessoaRepository.cadastrar(pessoa);
		
	}
	
}
