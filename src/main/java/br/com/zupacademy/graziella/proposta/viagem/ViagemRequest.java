package br.com.zupacademy.graziella.proposta.viagem;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViagemRequest {

	@NotBlank
	private String destino;
	@Future @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dataTermino;
	
	public String getDestino() {
		return destino;
	}
	
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	
}
