package br.com.rafaelmoreira.testes.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import br.com.rafaelmoreira.testes.model.Pessoa;

@WireMockTest(httpPort = 8080)
@SpringBootTest
public class PessoaControllerTest  {
	
	@Autowired
	private static WireMockServer wireMockServer;
	
	private PessoaController pessoaController;
	
	@BeforeAll
	public static void init() {
        wireMockServer.start();
	}
	
	@AfterAll
	public static void tearDown() {
		wireMockServer.stop();
	}
	
	@Test
	public void exampleTest() {
	    /**
	     * stubFor: cria mock do servidor
	     * WireMock.post: informa o verbo HTTP e qual endereço
	     * willReturn: especifica que haverá retorno conforme condições abaixo
	     * WireMock.aResponse(): cria uma resposta HTTP
	     * withStatus: qual código HTTP será retornado
	     * withHeader: cabeçalho de resposta
	     * withBody: corpo da resposta
	     * 
	     * Cria um mock para o servidor /pessoas usando POST e terá uma resposta HTTP 200 com cabeçalho
	     * informando que o retorno será um JSON e cria um objeto de retorno
	     * 
	     */
		try {
		    stubFor(WireMock.get("/pessoas/1")
		        .willReturn(WireMock.aResponse()
		        	.withStatus(200)
		            .withHeader("Content-Type", "application/json")
		            .withBody("{ \"id\":1, \"nome\":\"Rafael\", \"email\":\"rafael@email.com.br\", \"idade\":34 }")));
	
		    ResponseEntity<Pessoa> pessoa = pessoaController.recuperaPessoa(1L);
		    
		    assertTrue(pessoa.hasBody());
		    assertNotNull(pessoa.getBody().getId());
		    assertEquals(1L, pessoa.getBody().getId());
		    assertThat(pessoa.getStatusCode()).as("Wrong response status code").isEqualTo(200);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	   
	}
	
}
