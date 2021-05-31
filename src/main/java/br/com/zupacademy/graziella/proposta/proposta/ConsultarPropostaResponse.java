package br.com.zupacademy.graziella.proposta.proposta;

import br.com.zupacademy.graziella.proposta.bloqueio.StatusCartao;
import br.com.zupacademy.graziella.proposta.webservices.analise.Status;

public class ConsultarPropostaResponse {

	private String documento;
	private String email;
	private String nome;
	private Status statusProposta;
	private String cartao;
	private StatusCartao statusCartao;
	
	public ConsultarPropostaResponse(Proposta proposta) {
		this.documento = ofuscar(proposta.getDocumento());
		this.email = ofuscar(proposta.getEmail());
		this.nome = proposta.getNome();
		this.statusProposta = proposta.getStatus();
		if(proposta.getCartao() != null) {
			this.cartao = ofuscar(proposta.getCartao().getNumero());
			this.statusCartao = proposta.getCartao().getStatusCartao();
		} else {
			this.cartao = "Indisponivel";
			this.statusCartao = StatusCartao.INDISPONIVEL;
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

	public Status getStatusProposta() {
		return statusProposta;
	}

	public String getCartao() {
		return cartao;
	}
	
	public StatusCartao getStatusCartao() {
		return statusCartao;
	}
}
