package br.com.zupacademy.graziella.proposta.carteira;

import javax.validation.constraints.NotBlank;

public class NovaCarteiraRequest {

	@NotBlank
	private String email;
	private TipoCarteira carteira;
	
	public String getEmail() {
		return email;
	}
	
	public TipoCarteira getCarteira() {
		return carteira;
	}
	
	public NovaCarteiraRequest(String email, TipoCarteira carteira) {
		this.email = email;
		this.carteira = carteira;
	}
	
	@Deprecated
	public NovaCarteiraRequest() {
	}
	
}
