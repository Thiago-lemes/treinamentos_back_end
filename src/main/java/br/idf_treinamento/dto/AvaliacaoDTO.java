package br.idf_treinamento.dto;

public record AvaliacaoDTO(Long usuarioId,
                           int metas,
                           int autoconhecimento,
                           int leitura,
                           int gerenciamento,
                           int habilidades,
                           int mindfulness,
                           int vidaEspiritual,
                           int condicionamento) {
}

