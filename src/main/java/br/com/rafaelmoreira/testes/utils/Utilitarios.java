package br.com.rafaelmoreira.testes.utils;

import org.springframework.stereotype.Component;

@Component
public class Utilitarios {

	public static String converterUpperCase(String texto) throws Exception {
		if (texto == null || texto.isBlank() || texto.isEmpty()) {
			throw new Exception("Texto a ser convertido deve ser informado");
		}
		return texto.toUpperCase();
	}
	
	public String converterLowerCase(String texto) {
		return texto.toLowerCase();
	}
	
}
