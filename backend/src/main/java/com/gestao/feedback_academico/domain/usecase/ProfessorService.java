package com.gestao.feedback_academico.domain.usecase;


import com.gestao.feedback_academico.domain.dto.*;
import com.gestao.feedback_academico.domain.dto.detalhes.*;
import com.gestao.feedback_academico.domain.entity.User;

import java.util.List;

/**
 * Interface para operações de gerenciamento acadêmico relacionadas a atividades, turmas, aulas e avaliações.
 */
public interface ProfessorService {

    List<DetalhesUsuarioDto> listar();
    DetalhesUsuarioDto buscarProfessorPorEmail(String email);
    DetalhesUsuarioDto criar(CriarUsuarioDto novoProfessor);
    DetalhesUsuarioDto atualizar(DetalhesUsuarioDto detalhesUsuarioDto);
    void deletar(Long id);

}