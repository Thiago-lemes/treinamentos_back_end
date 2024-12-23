package br.idf_treinamento.dto;

import br.idf_treinamento.entity.UserRoleEnum;
import br.idf_treinamento.entity.UsuarioEntity;

public record UsuarioDTO(String nome, String email, UserRoleEnum role, String password) {

    public UsuarioEntity toEntity() {
        return new UsuarioEntity(nome, email, password, role);
    }
}
