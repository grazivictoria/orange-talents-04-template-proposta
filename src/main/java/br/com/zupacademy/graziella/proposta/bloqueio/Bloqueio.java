package br.com.zupacademy.graziella.proposta.bloqueio;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;

@Entity
public class Bloqueio {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataBloqueio = LocalDateTime.now();
	private String ipCliente;
	private String userAgente;
	@OneToOne
	private Cartao cartao;
	
	public Long getId() {
		return id;
	}
	public LocalDateTime getDataBloqueio() {
		return dataBloqueio;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public String getUserAgente() {
		return userAgente;
	}
	public Cartao getCartao() {
		return cartao;
	}
	
	public Bloqueio(String ipCliente, String userAgente, Cartao cartao) {
		this.ipCliente = ipCliente;
		this.userAgente = userAgente;
		this.cartao = cartao;
	}
	
	
}
