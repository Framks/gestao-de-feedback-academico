package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;

import java.util.List;

/**
 * Interface para o serviço de operações relacionadas aos alunos.
 */
public interface AlunoService {

    void criar(User user);
    void atualizar(User user);
    void remover(Long id);
    DetalhesUsuarioDto getAluno(Long id);
    List<DetalhesUsuarioDto> getAlunos();

}