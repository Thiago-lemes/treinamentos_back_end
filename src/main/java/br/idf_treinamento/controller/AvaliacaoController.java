package br.idf_treinamento.controller;

import br.idf_treinamento.dto.AvaliacaoDTO;
import br.idf_treinamento.entity.AvaliacaoEntity;
import br.idf_treinamento.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService service;

    @PostMapping("/create")
    public ResponseEntity<AvaliacaoEntity> criarAvaliacao(@RequestBody AvaliacaoDTO dto) {
        AvaliacaoEntity avaliacao = service.create(dto);
        return ResponseEntity.ok(avaliacao);
    }
}
