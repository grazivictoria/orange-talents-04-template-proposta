package br.com.zupacademy.graziella.proposta.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.zupacademy.graziella.proposta.util.validacoes.CpfCnpj;


public class NovaPropostaRequest {

	@NotNull @NotEmpty @CpfCnpj
	private String documento;
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @Positive
	private BigDecimal salario;
	
	public NovaPropostaRequest(@NotNull @NotEmpty @CpfCnpj String documento, @NotNull @NotEmpty @Email String email,
			@NotNull @NotEmpty String nome, @NotNull @NotEmpty String endereco, @NotNull BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public Proposta converter() {
		return new Proposta(documento, email, nome, endereco, salario);
	}

	public String getDocumento() {
		return documento;
	}

}
