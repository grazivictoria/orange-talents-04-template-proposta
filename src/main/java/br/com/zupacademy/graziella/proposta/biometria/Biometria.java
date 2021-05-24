package br.com.zupacademy.graziella.proposta.biometria;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;

@Entity
public class Biometria {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fingerprint;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne @NotNull
	private Cartao cartao;
	
	public Long getId() {
		return id;
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public Cartao getCartao() {
		return cartao;
	}
	
	@Deprecated
	public Biometria() {
	}
	
	public Biometria(String fingerprint, Cartao cartao) {
		this.fingerprint = fingerprint;
		this.cartao = cartao;
	}
	
}
