package br.com.zupacademy.graziella.proposta.webservices.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zupacademy.graziella.proposta.bloqueio.BloqueioResponse;
import br.com.zupacademy.graziella.proposta.bloqueio.NovoBloqueioRequest;

@Component
@FeignClient(name = "cartao", url = "${client.cartao}")
public interface CartaoClient {

	@GetMapping("/api/cartoes?idProposta={idProposta}")
	 public CartaoResponse consultaCartao(@PathVariable Long idProposta);
	
	@PostMapping("/api/cartoes/{id}/bloqueios")
	 public BloqueioResponse realizarBloqueio(@PathVariable String id,  @RequestBody NovoBloqueioRequest request);
	
}
