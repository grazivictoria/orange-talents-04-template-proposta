package br.com.zupacademy.graziella.proposta.webservices.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "cartao", url = "http://localhost:8888")
public interface CartaoClient {

	@PostMapping("/api/cartoes?idProposta={propostaId}")
	 public CartaoResponse consultaCartao(@PathVariable Long idProposta);
	
}
