package br.idf_treinamento.service;

import br.idf_treinamento.exception.UserNotFoundException;
import br.idf_treinamento.dto.AvaliacaoDTO;
import br.idf_treinamento.entity.AvaliacaoEntity;
import br.idf_treinamento.entity.UsuarioEntity;
import br.idf_treinamento.repository.AvaliacaoRepository;
import br.idf_treinamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;
    @Autowired
    private UsuarioRepository usuariorepository;

    public AvaliacaoEntity create(AvaliacaoDTO dto) {

        AvaliacaoEntity avaliacao = dto.toEntity();
        var usuario = findByUsuario(dto.usuarioId());

        avaliacao.setUser(usuario);
        avaliacao.setMediaAvaliacao(calculaMedia(dto));

        return repository.save(avaliacao);
    }

    public UsuarioEntity findByUsuario(Long id) {
        UsuarioEntity user = usuariorepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
        return user;
    }

    private double calculaMedia(AvaliacaoDTO dto) {
        int soma = dto.metas() + dto.autoconhecimento() + dto.leitura()
                + dto.gerenciamento() + dto.habilidades()
                + dto.mindfulness() + dto.vidaEspiritual() + dto.condicionamento();
        return soma / 8.0;
    }

}
