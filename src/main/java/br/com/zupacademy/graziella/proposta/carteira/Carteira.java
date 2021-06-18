package br.com.zupacademy.graziella.proposta.carteira;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;

@Entity
public class Carteira {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	@ManyToOne
	private Cartao cartao;
	@Enumerated(EnumType.STRING)
	private TipoCarteira tipoCarteira;
	
	public Carteira(String email, Cartao cartao, TipoCarteira tipoCarteira) {
		this.email = email;
		this.cartao = cartao;
		this.tipoCarteira = tipoCarteira;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public TipoCarteira getTipoCarteira() {
		return tipoCarteira;
	}
	
}
