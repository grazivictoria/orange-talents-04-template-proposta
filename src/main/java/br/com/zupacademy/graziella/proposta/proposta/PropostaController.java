package br.com.zupacademy.graziella.proposta.proposta;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.graziella.proposta.webservices.analise.AnaliseFinanceiraClient;
import br.com.zupacademy.graziella.proposta.webservices.analise.AnaliseFinanceiraRequest;
import br.com.zupacademy.graziella.proposta.webservices.analise.AnaliseFinanceiraResponse;
import br.com.zupacademy.graziella.proposta.webservices.analise.Status;
import feign.FeignException;

@RestController
@RequestMapping("/api/proposta")
public class PropostaController {

	@Autowired
	private PropostaRepository repository;
	@Autowired
	private AnaliseFinanceiraClient analiseFinanceiraClient;

	public PropostaController(PropostaRepository repository, AnaliseFinanceiraClient analiseFinanceiraClient) {
		this.repository = repository;
		this.analiseFinanceiraClient = analiseFinanceiraClient;
	}

	@PostMapping
	public ResponseEntity<?> salvarProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriBuilder) {
		
		if(repository.existsByDocumento(request.getDocumento())) {
			return ResponseEntity.unprocessableEntity().body("Já existe uma proposta cadastrada para esse documento");
		}
		
		Proposta proposta = request.converter();
		
		repository.save(proposta);
		
		try {
			AnaliseFinanceiraRequest analiseRequest = new AnaliseFinanceiraRequest(proposta.getDocumento(), proposta.getNome(), proposta.getId());
			AnaliseFinanceiraResponse analiseResponse = analiseFinanceiraClient.consultaRestricao(analiseRequest);
			
			Status status = analiseResponse.status();
			proposta.setStatus(status);
		} catch(FeignException.UnprocessableEntity unprocessableEntity) {
			proposta.setStatus(Status.NAO_ELEGIVEL);
		}
		
		repository.save(proposta);
		
		return ResponseEntity.created(uriBuilder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri()).body(proposta.getId());
	}
}
