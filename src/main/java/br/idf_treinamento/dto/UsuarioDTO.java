package br.idf_treinamento.dto;

import br.idf_treinamento.entity.UsuarioEntity;

public record UsuarioDTO(String nome, int telefone, String email) {

    public UsuarioEntity toEntity() {
        return new UsuarioEntity(nome, email, telefone);
    }
}
