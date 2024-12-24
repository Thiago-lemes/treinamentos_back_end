CREATE TABLE IF NOT EXISTS avaliacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nota_meta INT NOT NULL,
    nota_autoconhecimento INT NOT NULL,
    nota_leitura_aprendizado INT NOT NULL,
    nota_gerenciamento_prioridade INT NOT NULL,
    nota_habilidade_interpessoais INT NOT NULL,
    nota_mindfulness INT NOT NULL,
    nota_vida_espiritual INT NOT NULL,
    nota_condicionamento_fisico INT NOT NULL,
    media_avaliacao INT NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
