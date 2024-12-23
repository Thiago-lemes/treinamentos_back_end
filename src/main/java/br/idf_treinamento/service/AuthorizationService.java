package br.idf_treinamento.service;

import br.idf_treinamento.dto.AuthenticationDTO;
import br.idf_treinamento.dto.LoginResponseDTO;
import br.idf_treinamento.dto.UsuarioDTO;
import br.idf_treinamento.dto.UsuarioResponseDTO;
import br.idf_treinamento.entity.UsuarioEntity;
import br.idf_treinamento.infra.security.TokenService;
import br.idf_treinamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    public ResponseEntity<LoginResponseDTO> login(AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    public ResponseEntity<?> register(UsuarioDTO dto) {
        if (repository.findByEmail(dto.email()).isPresent()) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");
        }
        String encryptedPassword = passwordEncoder.encode(dto.password());
        UsuarioEntity usuario = new UsuarioEntity(dto.nome(), dto.email(), encryptedPassword, dto.role());
        UsuarioEntity novoUsuario = repository.save(usuario);

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(
                novoUsuario.getId(),
                novoUsuario.getNome(),
                novoUsuario.getEmail()
        );

        return ResponseEntity.ok(responseDTO);

    }
}
