package br.idf_treinamento.controller;

import br.idf_treinamento.dto.PlanoAcaoDTO;
import br.idf_treinamento.entity.PlanoDeAcaoEntity;
import br.idf_treinamento.service.PlanoDeAcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plano-acao")
public class PlanoDeAcaoController {
    @Autowired
    private PlanoDeAcaoService service;
    @PostMapping("/create")
    public ResponseEntity<PlanoDeAcaoEntity> cadastraPlanoDeAcao(@RequestBody PlanoAcaoDTO dto){
        PlanoDeAcaoEntity planoDeAcao = service.create(dto);
        return ResponseEntity.ok(planoDeAcao);
    }
}
