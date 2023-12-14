package br.com.rafaelmoreira.testes.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.rafaelmoreira.testes.service.PessoaService;

@WebMvcTest(PessoaController.class)
@ContextConfiguration(classes = PessoaControllerTest.TestConfig.class)
public class PessoaControllerTest  {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
    @Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void yourControllerTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/pessoas").param("id", "1"))
//               .andExpect(MockMvcResultMatchers.status().isOk())
//               .andExpect(MockMvcResultMatchers.content().json("{ \"id\":1, \"nome\":\"Rafael\", \"email\":\"rafael@email.com.br\", \"idade\":34 }"))
//               .andReturn();
    	MvcResult mvcResult = this.mockMvc.perform(get("/pessoas").param("1"))
    				.andDo(print())
    				.andExpect(MockMvcResultMatchers.status().isOk())
    				.andExpect(MockMvcResultMatchers.content().json("{ \"id\":1, \"nome\":\"Rafael\", \"email\":\"rafael@email.com.br\", \"idade\":34 }"))
    				.andReturn();

                    //TODO corrigir cenário de teste
    	
    	Assertions.assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
    }
    
    @Configuration
    @Import(PessoaController.class)
    static class TestConfig {

        // Configurações personalizadas aqui, se necessário

        @Bean
        public PessoaService pessoaService() {
            // Configuração personalizada do serviço, se necessário
            return new PessoaService();
        }
    }
    
}
