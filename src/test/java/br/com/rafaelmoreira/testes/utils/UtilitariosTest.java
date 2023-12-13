package br.com.rafaelmoreira.testes.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilitariosTest {
	
	@Autowired
	Utilitarios utils;
	
	String textoLowerCase;
	String textoUpperCase;
	@BeforeEach
	void setUp() {
		textoLowerCase = "texto de exemplo";
		textoUpperCase = "TEXTO DE EXEMPLO";
	}
	
	/**
	 * 
	 * 	@throws Exception
	 * 		Usado para validar se lançou uma Exceção específica.
	 */
	@Test
	@DisplayName("esperado retorno de excecao na conversão com texto em branco")
	public void deveRetornarExcecaoTextoBranco() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> Utilitarios.converterUpperCase(""));
		Assertions.assertEquals(exception.getMessage(), "Texto a ser convertido deve ser informado");
	}
	
	@Test
	@DisplayName("esperado retorno de excecao na conversão com texto em branco")
	public void deveRetornarExcecaoTextoNulo() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> Utilitarios.converterUpperCase(null));
		Assertions.assertEquals(exception.getMessage(), "Texto a ser convertido deve ser informado");
	}
	
	@Test
	@DisplayName("esperado retorno de sucesso na conversão para UpperCase")
	public void deveRetornarStringUpperCase() throws Exception {
		String textoRetorno = Utilitarios.converterUpperCase(textoLowerCase);
		Assertions.assertEquals(textoRetorno, textoUpperCase);
	}
	
	@Test
	@DisplayName("esperado retorno de sucesso na conversão para LowerCase")
	public void deveRetornarStringLowerCase() {
		String textoRetorno = utils.converterLowerCase(textoUpperCase);
		Assertions.assertEquals(textoRetorno, textoLowerCase);
	}
	
}
