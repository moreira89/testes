package br.com.rafaelmoreira.testes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.rafaelmoreira.testes.*"})
public class TestesAutomatizadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestesAutomatizadosApplication.class, args);
	}

}
