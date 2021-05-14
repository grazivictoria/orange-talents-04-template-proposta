package br.com.zupacademy.graziella.proposta.webservices.analise;

public class AnaliseFinanceiraResponse {

	private String documento;
	private String nome;
	private Long idProposta;
	private ResultadoAnalise resultadoSolicitacao;
	
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public Long getIdProposta() {
		return idProposta;
	}
	public ResultadoAnalise getResultadoAnalise() {
		return resultadoSolicitacao;
	}
	
	public Status status() {
		return resultadoSolicitacao.getStatus();
	}
	
	public AnaliseFinanceiraResponse(String documento, String nome, Long idProposta,
			ResultadoAnalise resultadoSolicitacao) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		this.resultadoSolicitacao = resultadoSolicitacao;
	}
	
}
