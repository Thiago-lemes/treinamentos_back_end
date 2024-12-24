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

        UsuarioEntity user = usuariorepository.findById(dto.usuarioId())
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
        avaliacao.setUser(user);
        avaliacao.setMediaAvaliacao(calculaMedia(dto));

        return repository.save(avaliacao);
    }

    private double calculaMedia(AvaliacaoDTO dto) {
        int soma = dto.metas() + dto.autoconhecimento() + dto.leitura()
                + dto.gerenciamento() + dto.habilidades()
                + dto.mindfulness() + dto.vidaEspiritual() + dto.condicionamento();
        return soma / 8.0;
    }

}
