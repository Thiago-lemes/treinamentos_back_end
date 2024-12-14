package br.idf_treinamento.repository;

import br.idf_treinamento.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
UserDetails findByEmail(String email);
}
