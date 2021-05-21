package br.com.zupacademy.graziella.proposta.webservices.analise;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "analise-financeira", url = "${client.analise}")
public interface AnaliseFinanceiraClient {

	@PostMapping("/api/solicitacao")
	 public AnaliseFinanceiraResponse consultaRestricao(@RequestBody AnaliseFinanceiraRequest request);
}
