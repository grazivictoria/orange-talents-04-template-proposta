package br.com.zupacademy.graziella.proposta.webservices.cartao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zupacademy.graziella.proposta.bloqueio.Bloqueio;
import br.com.zupacademy.graziella.proposta.bloqueio.StatusCartao;

@Entity
public class Cartao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	@OneToOne(cascade = CascadeType.MERGE)
	private Bloqueio bloqueio;
	@Enumerated(EnumType.STRING)
	private StatusCartao statusCartao = StatusCartao.ATIVO;
	
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
	

	public Bloqueio getBloqueio() {
		return bloqueio;
	}

	public StatusCartao getStatusCartao() {
		return statusCartao;
	}
	
	public void bloquear(Bloqueio bloqueio) {
		this.bloqueio = bloqueio;
        this.statusCartao = StatusCartao.BLOQUEADO;
	}
	
}
