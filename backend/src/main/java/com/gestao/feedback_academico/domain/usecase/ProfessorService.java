package com.gestao.feedback_academico.domain.usecase;


import com.gestao.feedback_academico.domain.dto.*;
import com.gestao.feedback_academico.domain.dto.detalhes.*;
import jakarta.validation.constraints.Positive;

import java.util.List;

/**
 * Interface para operações de gerenciamento acadêmico relacionadas a atividades, turmas, aulas e avaliações.
 */
public interface ProfessorService {

    List<DetalhesUsuarioDto> listar();
    DetalhesUsuarioDto buscarProfessorPorEmail(String email);
    DetalhesUsuarioDto criar(CriarUsuarioDto novoProfessor);
    DetalhesUsuarioDto atualizar(Long id,UpdateUser professor);
    void deletar(Long id);

    DetalhesUsuarioDto buscarPorId(@Positive Long id);
}