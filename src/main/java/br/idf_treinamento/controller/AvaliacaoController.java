package br.idf_treinamento.controller;

import br.idf_treinamento.dto.AvaliacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @PostMapping("/create")
    public ResponseEntity<String> criarAvaliacao(@RequestBody AvaliacaoDTO dto) {
        // Lógica para salvar a avaliação no banco de dados
        System.out.println("ID do Usuário: " + dto.usuarioId());
        System.out.println("Nota de Metas: " + dto.metas());
        return ResponseEntity.ok("Avaliação salva com sucesso!");
    }
}
