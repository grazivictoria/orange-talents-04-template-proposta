package br.com.zupacademy.graziella.proposta.webservices.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	
	public Cartao(String numero) {
		this.numero = numero;
	}
	
	@Deprecated
	public Cartao() {
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}
	
}
