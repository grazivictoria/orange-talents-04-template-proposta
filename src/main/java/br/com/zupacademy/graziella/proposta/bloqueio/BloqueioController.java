package br.com.zupacademy.graziella.proposta.bloqueio;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;
import br.com.zupacademy.graziella.proposta.webservices.cartao.CartaoClient;
import br.com.zupacademy.graziella.proposta.webservices.cartao.CartaoRepository;
import feign.FeignException;

@RestController
@RequestMapping("/api/bloqueio")
public class BloqueioController {

	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private CartaoClient cartaoCLient;
	
	@PostMapping("/{cartaoId}")
	public ResponseEntity<?> novoBloqueio(@PathVariable Long cartaoId, HttpServletRequest servletRequest, @RequestHeader(value = "User-Agent") String userAgent) {
		
		Optional<Cartao> possivelCartao = cartaoRepository.findById(cartaoId);
		
		if(possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = possivelCartao.get();
		try {
			
			cartaoCLient.realizarBloqueio(cartao.getNumero(), new NovoBloqueioRequest("Proposta"));
			Bloqueio novoBloqueio = new Bloqueio(servletRequest.getRemoteAddr(), userAgent, cartao);
			cartao.bloquear(novoBloqueio);
			
			cartaoRepository.save(cartao);
			
			return ResponseEntity.ok().build();
			
		} catch(FeignException e) {
			return ResponseEntity.unprocessableEntity().body("Não foi possível realizar o bloqueio");
		}
		
	}
}
