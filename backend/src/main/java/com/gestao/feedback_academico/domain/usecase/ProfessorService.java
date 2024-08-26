package com.gestao.feedback_academico.domain.usecase;


import com.gestao.feedback_academico.domain.dto.*;
import com.gestao.feedback_academico.domain.dto.detalhes.*;
import com.gestao.feedback_academico.domain.entity.User;

import java.util.List;

/**
 * Interface para operações de gerenciamento acadêmico relacionadas a atividades, turmas, aulas e avaliações.
 */
public interface ProfessorService {

    List<DetalhesUsuarioDto> getAllProfessores();
    DetalhesUsuarioDto getProfessorByemail(String email);
    DetalhesUsuarioDto criarProfessor(CriarUsuarioDto novoProfessor);
    DetalhesUsuarioDto atualizarProfessor(DetalhesUsuarioDto detalhesUsuarioDto);
    void deleteProfessor(Long id);

}