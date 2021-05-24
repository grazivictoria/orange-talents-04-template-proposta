package br.com.zupacademy.graziella.proposta.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.graziella.proposta.util.validacoes.CpfCnpj;


public class NovaPropostaRequest {

	@NotNull @NotBlank @CpfCnpj
	private String documento;
	@NotNull @NotBlank @Email
	private String email;
	@NotNull @NotBlank
	private String nome;
	@NotNull @NotBlank
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
