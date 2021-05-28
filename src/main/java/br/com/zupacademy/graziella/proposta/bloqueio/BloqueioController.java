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
import br.com.zupacademy.graziella.proposta.webservices.cartao.CartaoRepository;

@RestController
@RequestMapping("/api/bloqueio")
public class BloqueioController {

	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private BloqueioRepository bloqueioRepository;
	
	@PostMapping("/{cartaoId}")
	public ResponseEntity<?> novoBloqueio(@PathVariable Long cartaoId, HttpServletRequest servletRequest, @RequestHeader(value = "User-Agent") String userAgent) {

		Optional<Cartao> possivelCartao = cartaoRepository.findById(cartaoId);
		if(possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		if(bloqueioRepository.existsByCartaoId(cartaoId)) {
			return ResponseEntity.unprocessableEntity().body("Cartão já se encontra bloqueado");
		}
		Cartao cartao = possivelCartao.get();
		Bloqueio novoBloqueio = new Bloqueio(servletRequest.getRemoteAddr(), userAgent, cartao);
		bloqueioRepository.save(novoBloqueio);
		return ResponseEntity.ok().build();
	}
}
