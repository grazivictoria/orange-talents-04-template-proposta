package br.com.zupacademy.graziella.proposta.viagem;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;
import br.com.zupacademy.graziella.proposta.webservices.cartao.CartaoRepository;

@RestController
@RequestMapping("/api/viagem")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository;
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@PostMapping("/{cartaoId}")
	public ResponseEntity<?> novoAviso(@PathVariable Long cartaoId, @RequestBody @Valid ViagemRequest request, HttpServletRequest servletRequest, @RequestHeader(value = "User-Agent") String userAgent) {
		
		Optional<Cartao> possivelCartao = cartaoRepository.findById(cartaoId);
		if (possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = possivelCartao.get();
		AvisoViagem novoAviso = new AvisoViagem(request.getDestino(), request.getDataTermino(), servletRequest.getRemoteAddr(), userAgent, cartao);
		
		viagemRepository.save(novoAviso);
		
		return ResponseEntity.ok().build();
	}
}
