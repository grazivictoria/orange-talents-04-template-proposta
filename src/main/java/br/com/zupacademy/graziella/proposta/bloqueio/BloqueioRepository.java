package br.com.zupacademy.graziella.proposta.bloqueio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BloqueioRepository extends JpaRepository<Bloqueio, Long>{

	boolean existsByCartaoId(Long cartaoId);

}
