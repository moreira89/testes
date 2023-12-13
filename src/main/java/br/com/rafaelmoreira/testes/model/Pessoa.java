package br.com.rafaelmoreira.testes.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

	private Long id;
	private String nome;
	private Integer idade;
	private String email;
	
}
