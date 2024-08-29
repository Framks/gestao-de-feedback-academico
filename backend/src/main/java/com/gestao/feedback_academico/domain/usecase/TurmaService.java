package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.Turma;

import java.util.List;

public interface TurmaService {

    void criar(CriarTurmaDto turma);
    void atualizar(Turma turma);
    void remover(Turma turma);
    DetalhesTurmaDto buscarPorId(Long id);
    List<DetalhesTurmaDto> listar();
    void inserirAluno(Long IdTurma, Long IdAluno);
    void removerAluno(Long IdTurma, Long IdAluno);
    void disponibilizarAula(Long IdTurma, Long IdAula);
    void disponibilizarAtividade(Long IdTurma, Long IdAtividade);
    List<DetalhesUsuarioDto> listarAlunos();
}
