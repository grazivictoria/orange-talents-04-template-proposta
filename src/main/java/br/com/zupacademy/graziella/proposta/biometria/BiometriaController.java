package br.com.zupacademy.graziella.proposta.biometria;

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
import br.com.zupacademy.graziella.proposta.webservices.cartao.CartaoRepository;

@RestController
@RequestMapping("/api/biometria")
public class BiometriaController {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private BiometriaRepository biometriaRepository;
	
	@PostMapping("/{cartaoId}")
	public ResponseEntity<?> salvarBiometria(@PathVariable Long cartaoId, @RequestBody @Valid NovaBiometriaRequest request, UriComponentsBuilder uriBuilder) {
		
		Optional<Cartao> cartao = cartaoRepository.findById(cartaoId);
		if(!cartao.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			Biometria biometria = request.converter(request.getFingerprint(), cartao.get());
			biometriaRepository.save(biometria);
			
			return ResponseEntity.created(uriBuilder.path("/biometria/{id}").buildAndExpand(biometria.getId()).toUri()).body(biometria.getId());
		}
	}
}
