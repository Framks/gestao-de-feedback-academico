package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.entity.Turma;
import com.gestao.feedback_academico.domain.usecase.TurmaService;

import java.util.List;

public class TurmaServiceImpl implements TurmaService {
    @Override
    public void criar(CriarTurmaDto turma) {

    }

    @Override
    public void atualizar(Turma turma) {

    }

    @Override
    public void remover(Turma turma) {

    }

    @Override
    public DetalhesTurmaDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<DetalhesTurmaDto> buscar() {
        return List.of();
    }
}
