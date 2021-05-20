package br.com.zupacademy.graziella.proposta.proposta;

import br.com.zupacademy.graziella.proposta.webservices.analise.Status;

public class ConsultarPropostaResponse {

	private String documento;
	private String email;
	private String nome;
	private Status status;
	private String cartao;
	
	public ConsultarPropostaResponse(Proposta proposta) {
		this.documento = ofuscar(proposta.getDocumento());
		this.email = ofuscar(proposta.getEmail());
		this.nome = proposta.getNome();
		this.status = proposta.getStatus();
		if(proposta.getCartao() != null) {
			this.cartao = ofuscar(proposta.getCartao().getNumero());
		} else {
			this.cartao = "Indisponivel";
		}
	}

	public String ofuscar(String string) {
		
		return string.replace(
                string.substring(
                        3, string.length()-3),
                "***"
        );
	}
	
	@Deprecated
	public ConsultarPropostaResponse() {
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public Status getStatus() {
		return status;
	}

	public String getCartao() {
		return cartao;
	}
	
}
