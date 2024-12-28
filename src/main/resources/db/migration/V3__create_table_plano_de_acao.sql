CREATE TABLE IF NOT EXISTS plano_de_acao (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             metas_prioridades TEXT NOT NULL,
                                             metas_abordagem TEXT NOT NULL,
                                             autoconhecimento_forcas_avanco TEXT NOT NULL,
                                             autoconhecimento_fraquezas_melhorias TEXT NOT NULL,
                                             habilidades_comunicacao TEXT NOT NULL,
                                             habilidades_relacionamento TEXT NOT NULL,
                                             autocuidado_particas_rotina TEXT NOT NULL,
                                             mindfulness_aumento_foco TEXT NOT NULL,
                                             espiritual_dom_ministerial TEXT NOT NULL,
                                             espiritual_conecxao_profunda TEXT NOT NULL,
                                             aprendizado_para_adiquirir TEXT NOT NULL,
                                             leitura_aprendizado_continuo TEXT NOT NULL,
                                             fisico_mudanca_alimentacao TEXT NOT NULL,
                                             fisico_condicionamento TEXT NOT NULL,
                                             usuario_id BIGINT NOT NULL,
                                             CONSTRAINT fk_usuario_plano_acao FOREIGN KEY (usuario_id) REFERENCES usuario(id)
    );
