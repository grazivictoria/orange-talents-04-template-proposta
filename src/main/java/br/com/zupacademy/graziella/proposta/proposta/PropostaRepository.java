package br.com.zupacademy.graziella.proposta.proposta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long>{

	boolean existsByDocumento(String documento);

	@Query("select p from Proposta p where status = 'ELEGIVEL' and cartao_id is null")
	List<Proposta> buscarPropostasSemCartao();
}
