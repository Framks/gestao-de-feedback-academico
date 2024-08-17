package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.CriarAulaDto;
import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.usecase.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Override
    public List<DetalhesAtividadeDto> getAllAtividades() {
        return List.of();
    }

    @Override
    public List<DetalhesAulaDto> getAulasByTurma(IdTurmaDto turmaId) {
        return List.of();
    }

    @Override
    public List<DetalhesAtividadeDto> getAtividadesDisponibilizadas(IdTurmaDto turmaId) {
        return List.of();
    }

    @Override
    public DetalhesAtividadeDto disponibilizarAtividade(IdTurmaDto turmaId, CriarAtividadeDto criarAtividadeDto) {
        return null;
    }

    @Override
    public DetalhesTurmaDto criarTurma(CriarTurmaDto criarTurmaDto) {
        return null;
    }

    @Override
    public void apagarTurma(IdTurmaDto turmaId) {

    }

    @Override
    public DetalhesAulaDto criarAula(IdTurmaDto turmaId, CriarAulaDto criarAulaDto) {
        return null;
    }

    @Override
    public void apagarAula(IdTurmaDto turmaId, Long idAula) {

    }

    @Override
    public List<DetalhesAvaliacaoAulaAlunoDto> getAvaliacoesByAula(IdTurmaDto turmaId, Long idAula) {
        return List.of();
    }

    @Override
    public List<DetalhesAvaliacaoAtivAlunoDto> getAvaliacoesByAtividade(IdTurmaDto turmaId, Long atividadeId) {
        return List.of();
    }

    @Override
    public List<DetalhesAvaliacaoAulaAlunoDto> getAvaliacoesAulasByAluno(IdTurmaDto turmaId, Long matricula) {
        return List.of();
    }

    @Override
    public List<DetalhesAvaliacaoAtivAlunoDto> getAvaliacoesAtividadesByAluno(IdTurmaDto turmaId, Long matricula) {
        return List.of();
    }

    @Override
    public DetalhesUsuarioDto criarNovoAluno(CriarUsuarioDto criarUsuarioDto) {
        return null;
    }
}
