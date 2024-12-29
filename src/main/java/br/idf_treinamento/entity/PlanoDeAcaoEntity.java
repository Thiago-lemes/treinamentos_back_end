package br.idf_treinamento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plano_de_acao")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlanoDeAcaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metas_prioridades", nullable = false)
    private String metasPrioridades;

    @Column(name = "metas_abordagem", nullable = false)
    private String metasAbordagem;

    @Column(name = "autoconhecimento_forcas_avanco", nullable = false)
    private String forcasAvanco;

    @Column(name = "autoconhecimento_fraquezas_melhorias", nullable = false)
    private String fraquezasMelhorias;

    @Column(name = "habilidades_comunicacao", nullable = false)
    private String habilidadesComunicacao;

    @Column(name = "habilidades_relacionamento", nullable = false)
    private String habilidadesRelacionamento;

    @Column(name = "autocuidado_particas_rotina", nullable = false)
    private String particasRotina;

    @Column(name = "mindfulness_aumento_foco", nullable = false)
    private String mindfulnessAumentoFoco;

    @Column(name = "espiritual_dom_ministerial", nullable = false)
    private String espiritualMinisterial;

    @Column(name = "espiritual_conecxao_profunda", nullable = false)
    private String espiritualConecxaoProfunda;

    @Column(name = "fisico_condicionamento", nullable = false)
    private String fisicoCondicionamento;

    @Column(name = "fisico_mudanca_alimentacao", nullable = false)
    private String fisicoMudancaAlimentacao;

    @Column(name = "aprendizado_para_adiquirir", nullable = false)
    private String aprendizadoParaAdiquirir;

    @Column(name = "leitura_aprendizado_continuo", nullable = false)
    private String leituraAprendizadoContinuo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity user;

    public PlanoDeAcaoEntity(String metasPrioridades,
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
                             String leituraAprendizadoContinuo
    ) {
        this.metasPrioridades = metasPrioridades;
        this.metasAbordagem = metasAbordagem;
        this.forcasAvanco = forcasAvanco;
        this.fraquezasMelhorias = fraquezasMelhorias;
        this.habilidadesComunicacao = habilidadesComunicacao;
        this.habilidadesRelacionamento = habilidadesRelacionamento;
        this.particasRotina = praticasRotina;
        this.mindfulnessAumentoFoco = mindfulnessAumentoFoco;
        this.espiritualMinisterial = espiritualMinisterial;
        this.espiritualConecxaoProfunda = espiritualConecxaoProfunda;
        this.fisicoCondicionamento = fisicoCondicionamento;
        this.fisicoMudancaAlimentacao = fisicoMudancaAlimentacao;
        this.aprendizadoParaAdiquirir = aprendizadoParaAdiquirir;
        this.leituraAprendizadoContinuo = leituraAprendizadoContinuo;
    }
}
