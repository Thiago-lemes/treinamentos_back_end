package br.idf_treinamento.AvaliacaoTest;

import br.idf_treinamento.dto.AvaliacaoDTO;
import br.idf_treinamento.entity.AvaliacaoEntity;
import br.idf_treinamento.entity.UsuarioEntity;
import br.idf_treinamento.exception.UserNotFoundException;
import br.idf_treinamento.repository.AvaliacaoRepository;
import br.idf_treinamento.repository.UsuarioRepository;
import br.idf_treinamento.service.AvaliacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvaliacaoServiceTest {

    @InjectMocks
    private AvaliacaoService avaliacaoService;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    AvaliacaoDTO dto = new AvaliacaoDTO(
            1,
            8,
            9,
            7,
            10,
            9,
            8,
            7,
            1l
    );

    @Test
    void testeDoCreateAvaliacao() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(1L);
        usuario.setNome("Test User");

        AvaliacaoEntity savedAvaliacao = new AvaliacaoEntity();
        savedAvaliacao.setId(1L);
        savedAvaliacao.setMediaAvaliacao(8.25);
        savedAvaliacao.setUser(usuario);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(avaliacaoRepository.save(any(AvaliacaoEntity.class))).thenReturn(savedAvaliacao);

        AvaliacaoEntity result = avaliacaoService.create(dto);

        assertNotNull(result);
        assertEquals(8.25, result.getMediaAvaliacao());
        assertEquals(usuario, result.getUser());
        verify(usuarioRepository, times(1)).findById(1L);
        verify(avaliacaoRepository, times(1)).save(any(AvaliacaoEntity.class));
    }

    @Test
    void testFindByUsuarioQuandoOUsuarioExiste() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(1L);
        usuario.setNome("john doe");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        // Execução
        UsuarioEntity result = avaliacaoService.findByUsuario(1L);
        // Verificações
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("john doe", result.getNome());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByUsuarioQuandoNaoExisteUsuario() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> avaliacaoService.findByUsuario(1L));
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void testCalculaMedia() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(1L);
        usuario.setNome("Test User");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(avaliacaoRepository.save(any(AvaliacaoEntity.class))).thenAnswer(invocation -> {
            AvaliacaoEntity entity = invocation.getArgument(0);
            entity.setId(1L);
            return entity;
        });

        double media = avaliacaoService.create(dto).getMediaAvaliacao();
        assertEquals(7.375, media, 0.01);
        verify(usuarioRepository, times(1)).findById(1L);
        verify(avaliacaoRepository, times(1)).save(any(AvaliacaoEntity.class));
    }
}
