package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.application.service.AlunoServiceImpl;
import com.gestao.feedback_academico.interfaces.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import com.gestao.feedback_academico.interfaces.repository.AlunoRepository;
import com.gestao.feedback_academico.application.usecase.AlunoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class AlunoServiceTest {

    private AlunoService alunoService;
    private AlunoRepository alunoRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;


    @BeforeEach
    void setUp() {
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        alunoRepository = Mockito.mock(AlunoRepository.class);
        modelMapper = new ModelMapper();
        alunoService = new AlunoServiceImpl(alunoRepository, modelMapper, passwordEncoder);
    }

    @Test
    public void cadastrarNovoAlunoValido() {
        // Criando o DTO para o novo aluno
        CriarUsuarioDto novoAlunoDto = new CriarUsuarioDto(
                UserRole.ALUNO,
                "Primeiro Nome",
                "Segundo Nome",
                "aluno@email.com",
                "senha",
                "link.telegram",
                123456789
        );

        // Simulando o mapeamento do DTO para a entidade User
        User aluno = modelMapper.map(novoAlunoDto, User.class);
        aluno.setId(1L);  // Simulando um ID atribuído ao aluno após o cadastro no banco

        Optional<User> response_aluno = Optional.of(aluno);

        // Simulando o comportamento esperado dos mocks
        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("senhaCodificada"); // Senha codificada
        Mockito.when(alunoRepository.save(Mockito.any(User.class))).thenReturn(aluno); // Salva o aluno no banco
        Mockito.when(alunoRepository.findByEmail(Mockito.anyString())).thenReturn(response_aluno); // Retorna o aluno ao buscar pelo email

        // Validação
        DetalhesUsuarioDto resultado = alunoService.criar(novoAlunoDto);
        Assertions.assertEquals(aluno.getId(), resultado.getId());
        Assertions.assertEquals(aluno.getEmail(), resultado.getEmail());
    }

    @Test
    public void atualizarAlunoExistente() {
        // Criando o DTO para o aluno
        CriarUsuarioDto alunoAtualizadoDto = new CriarUsuarioDto(
                UserRole.ALUNO,
                "Nome Atualizado",
                "Sobrenome Atualizado",
                "atualizado@email.com",
                "novaSenha",
                "link.atualizado",
                123456789
        );

        // Simulando um aluno existente
        User alunoExistente = new User( "Primeiro", "Sobrenome", "email@email.com", "senhaAntiga", UserRole.ALUNO);

        // Simulando o comportamento esperado dos mocks
        Mockito.when(alunoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(alunoExistente)); // Busca o aluno por ID
        Mockito.when(alunoRepository.save(Mockito.any(User.class))).thenReturn(alunoExistente); // Salva o aluno atualizado

        // Chamando o método de atualização
        DetalhesUsuarioDto resultado = alunoService.atualizar(1L, alunoAtualizadoDto);

        // Validações
        Assertions.assertEquals("Nome Atualizado", resultado.getPrimeiroNome());
        Assertions.assertEquals("atualizado@email.com", resultado.getEmail());
        Mockito.verify(alunoRepository, Mockito.times(1)).save(alunoExistente); // Verifica se o método save foi chamado
    }

    @Test
    public void removerAlunoPorId() {
        // Teste para garantir que a exclusão seja feita sem lançar exceções

        // Chamando o método de remoção
        alunoService.remover(1L);

        // Verificando se o método `deleteById` foi chamado
        Mockito.verify(alunoRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void buscarAlunoPorIdExistente() {
        // Simulando um aluno específico
        User aluno = new User("Primeiro", "Aluno", "aluno@email.com", "senha", UserRole.ALUNO);

        // Simulando o comportamento esperado dos mocks
        Mockito.when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        // Chamando o método do serviço
        DetalhesUsuarioDto resultado = alunoService.buscarAlunoPorId(1L);

        // Validações
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(aluno.getId(), resultado.getId());
        Assertions.assertEquals(aluno.getEmail(), resultado.getEmail());
    }

    @Test
    public void listarAlunos() {
        // Criando lista de alunos
        User aluno1 = new User( "Primeiro", "Aluno", "aluno1@email.com", "123", UserRole.ALUNO);
        User aluno2 = new User( "Segundo", "Aluno", "aluno2@email.com", "456", UserRole.ALUNO);

        List<User> listaAlunos = List.of(aluno1, aluno2);

        // Simulando o comportamento esperado dos mocks
        Mockito.when(alunoRepository.findAllByRole(UserRole.ALUNO)).thenReturn(Optional.of(listaAlunos));

        // Chamando o método do serviço
        List<DetalhesUsuarioDto> resultado = alunoService.listar();

        // Validações
        Assertions.assertEquals(2, resultado.size());
        Assertions.assertEquals(aluno1.getId(), resultado.get(0).getId());
        Assertions.assertEquals(aluno2.getId(), resultado.get(1).getId());
    }
}
