package br.com.zupacademy.graziella.proposta.proposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zupacademy.graziella.proposta.util.validacoes.CpfCnpj;

@Entity
public class Proposta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CpfCnpj
	private String cpfCnpj;
	private String email;
	private String nome;
	private String endereco;
	private BigDecimal salario;
	
	public Proposta() {
		
	}

	public Proposta(String cpfCnpj, String email, String nome, String endereco, BigDecimal salario) {
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public Object getId() {
		return id;
	}
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
}
