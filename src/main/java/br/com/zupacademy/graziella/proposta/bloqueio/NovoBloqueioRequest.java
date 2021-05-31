package br.com.zupacademy.graziella.proposta.bloqueio;

public class NovoBloqueioRequest {

	private String sistemaResponsavel;

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public NovoBloqueioRequest(String sistemaResponsavel) {
		this.sistemaResponsavel = sistemaResponsavel;
	}

	@Deprecated
	public NovoBloqueioRequest() {
	}
	
}
