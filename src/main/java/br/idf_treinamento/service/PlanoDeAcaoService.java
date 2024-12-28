package br.idf_treinamento.service;

import br.idf_treinamento.dto.PlanoAcaoDTO;
import br.idf_treinamento.entity.PlanoDeAcaoEntity;
import br.idf_treinamento.repository.PlanoDeAcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoDeAcaoService {
    @Autowired
    private PlanoDeAcaoRepository repository;

    @Autowired
    private AvaliacaoService avaliacaoService;

    public PlanoDeAcaoEntity create(PlanoAcaoDTO dto) {
        PlanoDeAcaoEntity planoDeAcao = dto.toEntity();
        var usuario = avaliacaoService.findByUsuario(dto.id());
        planoDeAcao.setUser(usuario);
        return repository.save(planoDeAcao);
    }

}
