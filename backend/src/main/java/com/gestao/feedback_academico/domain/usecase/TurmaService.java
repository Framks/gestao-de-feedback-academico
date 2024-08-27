package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.entity.Turma;

import java.util.List;

public interface TurmaService {

    void criar(CriarTurmaDto turma);
    void atualizar(Turma turma);
    void remover(Turma turma);
    DetalhesTurmaDto buscarPorId(Long id);
    List<DetalhesTurmaDto> buscar();
}
