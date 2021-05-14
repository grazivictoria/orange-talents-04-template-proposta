package br.com.zupacademy.graziella.proposta.webservices.analise;

public enum ResultadoAnalise {

	COM_RESTRICAO(Status.NAO_ELEGIVEL),
	SEM_RESTRICAO(Status.ELEGIVEL);
	
	private Status status;
	
	ResultadoAnalise(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
	
}
