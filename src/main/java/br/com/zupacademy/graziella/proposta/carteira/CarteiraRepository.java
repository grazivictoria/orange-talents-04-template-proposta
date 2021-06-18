package br.com.zupacademy.graziella.proposta.carteira;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.graziella.proposta.webservices.cartao.Cartao;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

	boolean existsByCartaoAndTipoCarteira(Cartao cartao, TipoCarteira tipoCarteira);

}
