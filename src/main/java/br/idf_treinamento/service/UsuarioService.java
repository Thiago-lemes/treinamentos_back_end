package br.idf_treinamento.service;

import br.idf_treinamento.dto.UsuarioDTO;
import br.idf_treinamento.entity.UsuarioEntity;
import br.idf_treinamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity create(UsuarioDTO dto){
        UsuarioEntity usuarioCriado = dto.toEntity();
        return repository.save(usuarioCriado);
    }
}
