package br.com.zupacademy.graziella.proposta.proposta;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

	private PropostaRepository repository;

	public PropostaController(PropostaRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> salvarProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriBuilder) {
		
		Proposta proposta = request.converter();
		Optional<Proposta> cpfCnpjList = repository.findByCpfCnpj(proposta.getCpfCnpj());
		
		if(cpfCnpjList.isPresent()) {
			return ResponseEntity.unprocessableEntity().body("Já existe uma proposta cadastrada para esse documento");
		}
		
		repository.save(proposta);
		
		return ResponseEntity.created(uriBuilder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri()).body(proposta.getId());
	}
}
