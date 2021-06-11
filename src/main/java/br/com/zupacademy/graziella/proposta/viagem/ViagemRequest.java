package br.com.zupacademy.graziella.proposta.viagem;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViagemRequest {

	@NotBlank
	private String destino;
	@Future @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate validoAte;
	
	public String getDestino() {
		return destino;
	}
	
	public LocalDate getValidoAte() {
		return validoAte;
	}

	public ViagemRequest(@NotBlank String destino, @Future LocalDate validoAte) {
		this.destino = destino;
		this.validoAte = validoAte;
	}

	@Deprecated
	public ViagemRequest() {
	}
	
	
}
