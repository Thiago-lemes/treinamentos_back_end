package br.idf_treinamento.controller;

import br.idf_treinamento.dto.UsuarioDTO;
import br.idf_treinamento.entity.UsuarioEntity;
import br.idf_treinamento.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro_user")
public class CadastroController {
private final UsuarioService service;

    public CadastroController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioEntity> cadastro(@RequestBody UsuarioDTO dto) {
        UsuarioEntity usuario = service.create(dto);
        return ResponseEntity.ok(usuario);
    }
}
