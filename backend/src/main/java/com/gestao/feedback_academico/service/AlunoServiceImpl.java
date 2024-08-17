package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.usecase.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {


    @Override
    public DetalhesAvaliacaoAtivAlunoDto avaliarAtividade(CriarAvaliacaoAtivAlunoDto criarAvaliacaoAtivAlunoDto) {
        return null;
    }

    @Override
    public DetalhesAvaliacaoAtivAlunoDto avaliarAula(CriarAvaliacaoAulaAlunoDto criarAvaliacaoAulaAlunoDto) {
        return null;
    }

    @Override
    public List<DetalhesAulaDto> getAulasByTurma(IdTurmaDto idTurma) {
        return List.of();
    }

    @Override
    public List<DetalhesAulaDto> getAulasAvaliadasByAluno(Long matricula) {
        return List.of();
    }

    @Override
    public List<DetalhesAtividadeDto> getAtividadesByTurma(IdTurmaDto idTurma) {
        return List.of();
    }

    @Override
    public List<DetalhesAtividadeDto> getAtividadesAvaliadasByAluno(Long matricula) {
        return List.of();
    }
}
