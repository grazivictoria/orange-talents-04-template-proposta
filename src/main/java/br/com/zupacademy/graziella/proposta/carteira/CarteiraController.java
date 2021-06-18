package br.com.zupacademy.graziella.proposta.carteira;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;
import br.com.zupacademy.graziella.proposta.webservices.cartao.CartaoClient;
import br.com.zupacademy.graziella.proposta.webservices.cartao.CartaoRepository;
import feign.FeignException;

@RestController
@RequestMapping("/api/carteira")
public class CarteiraController {

	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private CartaoClient cartaoClient;
	@Autowired
	private CarteiraRepository carteiraRepository;

	@PostMapping("/{cartaoId}")
	public ResponseEntity<?> cadastrarCarteira(@PathVariable Long cartaoId, @RequestBody @Valid NovaCarteiraRequest request, UriComponentsBuilder uriBuilder) {
		
		Optional<Cartao> possivelCartao = cartaoRepository.findById(cartaoId);
		
		if(possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = possivelCartao.get();
		
		if(carteiraRepository.existsByCartaoAndTipoCarteira(cartao, request.getCarteira())) {
			return ResponseEntity.unprocessableEntity().body("Cartão já cadastrado para essa carteira");
		}
		
		try {
			cartaoClient.cadastrarCarteira(cartao.getNumero(), request);
			Carteira novaCarteira = new Carteira(request.getEmail(), cartao, request.getCarteira());
			carteiraRepository.save(novaCarteira);
			
			return ResponseEntity.created(uriBuilder.path("/proposta/{id}").buildAndExpand(novaCarteira.getId()).toUri()).build();
			
		} catch(FeignException e) {
			return ResponseEntity.unprocessableEntity().build();
		}

	}
}
