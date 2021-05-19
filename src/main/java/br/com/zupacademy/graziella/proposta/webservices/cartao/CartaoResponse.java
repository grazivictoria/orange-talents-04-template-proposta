package br.com.zupacademy.graziella.proposta.webservices.cartao;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CartaoResponse {
 
	@JsonAlias("id")
	private String numero;

	public Cartao converter() {
		return new Cartao(numero);
	}

	@Deprecated
	public CartaoResponse() {
	}

	public CartaoResponse(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
	
}
