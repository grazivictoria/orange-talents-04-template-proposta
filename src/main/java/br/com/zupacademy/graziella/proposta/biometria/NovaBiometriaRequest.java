package br.com.zupacademy.graziella.proposta.biometria;

import java.util.Base64;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;

public class NovaBiometriaRequest {

	@NotNull @NotBlank
	private String fingerprint;
	
	public String getFingerprint() {
		return fingerprint;
	}

	public Biometria converter(String fingerprint, Cartao cartao) {
		String biometria = Base64.getEncoder().encodeToString(fingerprint.getBytes());
		return new Biometria(biometria, cartao);
	}
}
