package br.idf_treinamento.controller;

import br.idf_treinamento.dto.AuthenticationDTO;
import br.idf_treinamento.dto.UsuarioDTO;
import br.idf_treinamento.service.AuthorizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthorizationService authorizationService;

    public AuthenticationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    /**
     * @param dto Dados de autenticação.
     * @return Token de acesso em caso de sucesso.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthenticationDTO dto) {
        return authorizationService.login(dto);
    }

    /**
     * Endpoint para registro de usuário.
     * @param dto Dados do usuário.
     * @return Status da operação.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated UsuarioDTO dto) {
        return authorizationService.register(dto);
    }
}
