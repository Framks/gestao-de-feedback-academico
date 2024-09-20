package com.gestao.feedback_academico.application.usecase;

import com.gestao.feedback_academico.interfaces.dto.CriarTurmaDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesTurmaDto;

import java.util.List;

public interface TurmaService {

    DetalhesTurmaDto criar(CriarTurmaDto turma);
    void atualizar(Long id, CriarTurmaDto turma);
    void remover(Long id);
    DetalhesTurmaDto buscarPorId(Long id);
    List<DetalhesTurmaDto> listar();
}
