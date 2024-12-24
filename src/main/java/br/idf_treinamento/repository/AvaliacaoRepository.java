package br.idf_treinamento.repository;

import br.idf_treinamento.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository <AvaliacaoEntity, Long> {

}
