package br.idf_treinamento.dto;

import br.idf_treinamento.entity.AvaliacaoEntity;

public record AvaliacaoDTO(
        int metas,
        int autoconhecimento,
        int leitura,
        int gerenciamento,
        int habilidades,
        int mindfulness,
        int vidaEspiritual,
        int condicionamento,
        Long usuarioId
) {

    public AvaliacaoEntity toEntity() {
        return new AvaliacaoEntity(metas, autoconhecimento, leitura, gerenciamento, habilidades, mindfulness,
                vidaEspiritual, condicionamento);
    }
}
