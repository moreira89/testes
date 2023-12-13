package br.com.rafaelmoreira.testes.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculadoraTest {
	
	@Autowired 
	Calculadora calculadora;

	@Test
	@DisplayName("esperado retorno de sucesso na soma de dois inteiros")
	public void deveRetornarSomaCorreta() {
		int somaRetorno = calculadora.soma(5, 3);
		Assertions.assertEquals(somaRetorno, 8);
	}
	
}
