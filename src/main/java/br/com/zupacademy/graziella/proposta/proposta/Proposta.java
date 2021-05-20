package br.com.zupacademy.graziella.proposta.proposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zupacademy.graziella.proposta.util.validacoes.CpfCnpj;
import br.com.zupacademy.graziella.proposta.webservices.analise.Status;
import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;

@Entity
public class Proposta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CpfCnpj
	private String documento;
	private String email;
	private String nome;
	private String endereco;
	private BigDecimal salario;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToOne
	private Cartao cartao;
	
	public Proposta() {
		
	}

	public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public Status getStatus() {
		return status;
	}

}
