package br.com.zupacademy.graziella.proposta.viagem;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;

@Entity
public class AvisoViagem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String destino;
	private LocalDateTime dataAviso = LocalDateTime.now();
	@Future
	private LocalDate dataTermino;
	@NotBlank
	private String ipCliente;
	@NotBlank
	private String userAgent;
	@ManyToOne
	private Cartao cartao;
	
	public Long getId() {
		return id;
	}
	public String getDestino() {
		return destino;
	}
	public LocalDateTime getDataAviso() {
		return dataAviso;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public Cartao getCartao() {
		return cartao;
	}
	
	public AvisoViagem(@NotBlank String destino, @Future LocalDate dataTermino,
			@NotBlank String ipCliente, @NotBlank String userAgent, Cartao cartao) {
		this.destino = destino;
		this.dataTermino = dataTermino;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.cartao = cartao;
	}
	
	@Deprecated
	public AvisoViagem() {
	}
	
}
