package br.com.zupacademy.graziella.proposta.viagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository extends JpaRepository<AvisoViagem, Long>{

}
