package br.com.zupacademy.graziella.proposta.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;


public class NovaPropostaRequest {

	@NotNull @NotEmpty
	private String cpfCnpj;
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @Positive
	private BigDecimal salario;
	
	public NovaPropostaRequest(@NotNull @NotEmpty @CPF @CNPJ String cpfCnpj, @NotNull @NotEmpty @Email String email,
			@NotNull @NotEmpty String nome, @NotNull @NotEmpty String endereco, @NotNull BigDecimal salario) {
		super();
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public Proposta converter() {
		return new Proposta(cpfCnpj, email, nome, endereco, salario);
	}

}
