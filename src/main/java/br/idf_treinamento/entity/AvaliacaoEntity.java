package br.idf_treinamento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avaliacao")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AvaliacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nota_meta", nullable = false)
    private Integer notaMeta;

    @Column(name = "nota_autoconhecimento", nullable = false)
    private Integer notaAutoconhecimento;

    @Column(name = "nota_leitura_aprendizado", nullable = false)
    private Integer notaLeituraAprendizado;

    @Column(name = "nota_gerenciamento_prioridade", nullable = false)
    private Integer notaGerenciamentoPrioridade;

    @Column(name = "nota_habilidade_interpessoais", nullable = false)
    private Integer notaHabilidadeInterpessoais;

    @Column(name = "nota_mindfulness", nullable = false)
    private Integer notaMindfulness;

    @Column(name = "nota_vida_espiritual", nullable = false)
    private Integer notaVidaEspiritual;

    @Column(name = "nota_condicionamento_fisico", nullable = false)
    private Integer notaCondicionamentoFisico;

    @Column(name = "media_avaliacao", nullable = false)
    private Double mediaAvaliacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity user;



    public AvaliacaoEntity(int metas, int autoconhecimento, int leitura, int gerenciamento,
                           int habilidades, int mindfulness, int vidaEspiritual,
                           int condicionamento) {
        this.notaMeta = metas;
        this.notaAutoconhecimento = autoconhecimento;
        this.notaLeituraAprendizado = leitura;
        this.notaGerenciamentoPrioridade = gerenciamento;
        this.notaHabilidadeInterpessoais = habilidades;
        this.notaMindfulness = mindfulness;
        this.notaVidaEspiritual = vidaEspiritual;
        this.notaCondicionamentoFisico = condicionamento;
    }

}
