package br.idf_treinamento.dto;

import br.idf_treinamento.entity.PlanoDeAcaoEntity;

public record PlanoAcaoDTO(
        Long id,
        String metasPrioridades,
        String metasAbordagem,
        String forcasAvanco,
        String fraquezasMelhorias,
        String habilidadesComunicacao,
        String habilidadesRelacionamento,
        String praticasRotina,
        String mindfulnessAumentoFoco,
        String espiritualMinisterial,
        String espiritualConecxaoProfunda,
        String fisicoCondicionamento,
        String fisicoMudancaAlimentacao,
        String aprendizadoParaAdiquirir,
        String leituraAprendizadoContinuo,
        Long usuarioId
) {
    public PlanoDeAcaoEntity toEntity() {
        return new PlanoDeAcaoEntity(
                metasPrioridades,
                metasAbordagem,
                forcasAvanco,
                fraquezasMelhorias,
                habilidadesComunicacao,
                habilidadesRelacionamento,
                praticasRotina,
                mindfulnessAumentoFoco,
                espiritualMinisterial,
                espiritualConecxaoProfunda,
                fisicoCondicionamento,
                fisicoMudancaAlimentacao,
                aprendizadoParaAdiquirir,
                leituraAprendizadoContinuo);
    }
}