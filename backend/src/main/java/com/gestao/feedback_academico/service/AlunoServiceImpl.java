package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AulaDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AvaliacaoAtividadeDto;
import com.gestao.feedback_academico.domain.dto.AvaliacaoAulaDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.usecase.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {


    @Override
    public AvaliacaoAtividadeDto avaliarAtividade(AvaliacaoAtividadeDto avaliacaoAtividadeDto) {
        return null;
    }

    @Override
    public AvaliacaoAulaDto avaliarAula(AvaliacaoAulaDto avaliacaoAulaDto) {
        return null;
    }

    @Override
    public List<AulaDetalhesDto> getAulasByTurma(IdTurmaDto idTurma) {
        return List.of();
    }

    @Override
    public List<AulaDetalhesDto> getAulasAvaliadasByAluno(Long matricula) {
        return List.of();
    }

    @Override
    public List<AtividadeDetalhesDto> getAtividadesByTurma(IdTurmaDto idTurma) {
        return List.of();
    }

    @Override
    public List<AtividadeDetalhesDto> getAtividadesAvaliadasByAluno(Long matricula) {
        return List.of();
    }
}
