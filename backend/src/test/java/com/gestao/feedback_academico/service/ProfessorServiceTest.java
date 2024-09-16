package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import com.gestao.feedback_academico.domain.repository.ProfessorRepository;
import com.gestao.feedback_academico.domain.usecase.ProfessorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class ProfessorServiceTest {

    private ProfessorRepository professorRepository;
    private ModelMapper modelMapper;
    private ProfessorService professorService;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        professorRepository = Mockito.mock(ProfessorRepository.class);
        modelMapper = new ModelMapper();
        professorService = new ProfessorServiceImpl(professorRepository, modelMapper, passwordEncoder);
    }

    @Test
    public void cadastrarNovoProfessorValido() {
        // Criando o DTO para o novo professor
        CriarUsuarioDto novoProfessorDto = new CriarUsuarioDto(
                UserRole.PROFESSOR,
                "primeiro nome",
                "segundo nome",
                "email@email.com",
                "senha",
                "link.me/tel",
                987665433
        );

        // Simulando o mapeamento do DTO para a entidade User
        User professor = modelMapper.map(novoProfessorDto, User.class);
        professor.setId(1L);  // Simulando um ID atribuído ao professor após o cadastro no banco

        Optional<User> response_professor = Optional.of(professor);

        // Simulando o comportamento esperado dos mocks
        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("1234"); // Senha codificada
        Mockito.when(professorRepository.save(Mockito.any(User.class))).thenReturn(professor); // Salva o professor no banco
        Mockito.when(professorRepository.findByEmail(Mockito.anyString())).thenReturn(response_professor); // Retorna o professor ao buscar pelo email

        // Validação
        DetalhesUsuarioDto resultado = professorService.criar(novoProfessorDto);
        Assertions.assertEquals(professor.getId(), resultado.getId());
        Assertions.assertEquals(professor.getEmail(), resultado.getEmail());
    }

    @Test
    public void listarProfessores() {
        User professor1 = new User( "Primeiro", "Professor", "email1@email.com", "123", UserRole.PROFESSOR);
        User professor2 = new User( "Segundo", "Professor", "email2@email.com", "456", UserRole.PROFESSOR);

        List<User> listaProfessores = List.of(professor1, professor2);

        Mockito.when(professorRepository.findAllByRole(UserRole.PROFESSOR)).thenReturn(Optional.of(listaProfessores));


        List<DetalhesUsuarioDto> resultado = professorService.listar();


        Assertions.assertEquals(2, resultado.size());
        Assertions.assertEquals(professor1.getId(), resultado.get(0).getId());
        Assertions.assertEquals(professor2.getId(), resultado.get(1).getId());
    }

    @Test
    public void buscarProfessorPorIdExistente() {
        User professor = new User( "Primeiro", "Professor", "email@email.com", "123", UserRole.PROFESSOR);


        Mockito.when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        DetalhesUsuarioDto resultado = professorService.buscarPorId(1L);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(professor.getId(), resultado.getId());
        Assertions.assertEquals(professor.getEmail(), resultado.getEmail());
    }

    @Test
    public void deletarProfessorPorId() {
        professorService.deletar(1L);

        Mockito.verify(professorRepository, Mockito.times(1)).deleteById(1L);
    }
}
