package br.com.zupacademy.graziella.proposta.webservices.cartao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zupacademy.graziella.proposta.proposta.Proposta;
import br.com.zupacademy.graziella.proposta.proposta.PropostaRepository;

@Component
public class CartaoSchedule {

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private CartaoClient cartaoClient;
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Scheduled(fixedDelayString = "${periodicidade.consulta-cartao}")
	private void consultaCartao() {
		List<Proposta> propostas = propostaRepository.buscarPropostasSemCartao();
		
		for (Proposta proposta : propostas) {
			CartaoResponse response = cartaoClient.consultaCartao(proposta.getId());
			Cartao cartao = response.converter();
			cartaoRepository.save(cartao);
			proposta.setCartao(cartao);
			propostaRepository.save(proposta);
			
		}
	}
}
