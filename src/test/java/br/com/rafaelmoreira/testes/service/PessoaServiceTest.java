package br.com.rafaelmoreira.testes.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rafaelmoreira.testes.model.Pessoa;
import br.com.rafaelmoreira.testes.repository.PessoaRepository;

@SpringBootTest
/**
 * 	@ExtendWith(MockitoExtension.class)
 * 		Extende o ciclo de vida de testes, neste caso para usar o Mockito
 */
@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

	/**
	 * 	@InjectMocks
	 * 		Injeta automaticamente mocks criados com o @Mock na instância criada durante a execução
	 */
	@InjectMocks
	PessoaService service;
	
	/**
	 * 	@Mock
	 * 		cria um mock de uma classe para retornar um valor pré-definido
	 */
	@Mock
	PessoaRepository repository;
	
	Pessoa pessoa;
	Pessoa pessoaRetorno;
	
	@BeforeEach
	void setUp() {
		pessoa = Pessoa.builder()
				.nome("Rafael")
				.email("rafael@email.com.br")
				.idade(34)
				.build();
		pessoaRetorno = Pessoa.builder()
				.id(1L)
				.nome("Rafael")
				.email("rafael@email.com.br")
				.idade(34)
				.build();
	}
	
	@Test
	@DisplayName("esperado retorno de sucesso no cadastro de Pessoa")
	public void deveRetornarPessoaCadastrada() throws Exception {
		/**
		 * 	Método: when
		 * 		Configura comportamento do mock. Quando for chamado o método X (repository.cadastrar) no service, deve retornar Y (pessoaRetorno)
		 *  Método: thenReturn
		 *		Não entra na classe mockada, assume que a classe retornará um objeto mock/pré-definido
		 */
		when(repository.cadastrar(pessoa)).thenReturn(pessoaRetorno);
		
		Pessoa p = service.cadastrarPessoa(pessoa);
		
		/**
		 * 	Método: verify
		 * 		verifica se o método foi executado com o argumento informado
		 * 		Garante que o método foi chamado (ou não)
		 * 
		 * 	Deve ser chamado após o service, para verificar se durante a execução do service, o método foi executado
		 */
		verify(repository).cadastrar(any());
		/**
		 * Pode ser passado um objeto específico OU
		 * 		any() - qualquer valor de qualquer tipo.
		 * 		anyString() - qualquer valor de tipo String.
		 * 		anyInt() - qualquer valor de tipo int.
		 * 		anyObject() - qualquer valor de qualquer tipo de obje
		 */
		
		Assertions.assertTrue(p.getId() != null);
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com pessoa nula")
	public void deveRetornarExcecaoPessoaNula() {
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(null));
		Assertions.assertEquals(exception.getMessage(), "Nenhuma informação foi passada");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com nome em branco")
	public void deveRetornarExcecaoNomeBranco() {
		pessoa.setNome("");
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Nome da pessoa deve ser informado");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com nome nulo")
	public void deveRetornarExcecaoNomeNulo() {
		pessoa.setNome(null);
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Nome da pessoa deve ser informado");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com nome vazio")
	public void deveRetornarExcecaoNomeVazio() {
		pessoa.setNome(" ");
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Nome da pessoa deve ser informado");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com email nula")
	public void deveRetornarExcecaoEmailNulo() {
		pessoa.setEmail(null);
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Email da pessoa deve ser informado");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com email branco")
	public void deveRetornarExcecaoEmailBranco() {
		pessoa.setEmail("");
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Email da pessoa deve ser informado");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com email vazio")
	public void deveRetornarExcecaoEmailVazio() {
		pessoa.setEmail(" ");
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Email da pessoa deve ser informado");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com pessoa nula")
	public void deveRetornarExcecaoIdadeNula() {
		pessoa.setIdade(null);
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Idade da pessoa deve ser informado");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com pessoa nula")
	public void deveRetornarExcecaoIdadeMenorQueZero() {
		pessoa.setIdade(0);
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Idade incorreta");
	}
	
	@Test
	@DisplayName("esperado exceção no cadastro com pessoa nula")
	public void deveRetornarExcecaoIdadeMenorIdade() {
		pessoa.setIdade(15);
		Throwable exception = assertThrows(Exception.class, () -> service.cadastrarPessoa(pessoa));
		Assertions.assertEquals(exception.getMessage(), "Não é permitido entrada de menores de idade");
	}
	
}
