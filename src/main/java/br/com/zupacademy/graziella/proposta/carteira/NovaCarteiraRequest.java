package br.com.zupacademy.graziella.proposta.carteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class NovaCarteiraRequest {

	@NotBlank @Email
	private String email;
	@NotNull
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
