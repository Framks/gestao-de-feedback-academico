package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AulaDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AvaliacaoDetalhesDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.NovaAtividadeDto;
import com.gestao.feedback_academico.domain.dto.NovaAulaDto;
import com.gestao.feedback_academico.domain.dto.NovaTurmaDto;
import com.gestao.feedback_academico.domain.dto.TurmaDetalhesDto;
import com.gestao.feedback_academico.domain.usecase.ProfessorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Override
    public List<AtividadeDetalhesDto> getAllAtividades() {
        return List.of();
    }

    @Override
    public List<AulaDetalhesDto> getAulasByTurma(IdTurmaDto turmaId) {
        return List.of();
    }

    @Override
    public List<AtividadeDetalhesDto> getAtividadesDisponibilizadas(IdTurmaDto turmaId) {
        return List.of();
    }

    @Override
    public AtividadeDetalhesDto disponibilizarAtividade(IdTurmaDto turmaId, NovaAtividadeDto novaAtividadeDto) {
        return null;
    }

    @Override
    public TurmaDetalhesDto criarTurma(NovaTurmaDto novaTurmaDto) {
        return null;
    }

    @Override
    public void apagarTurma(IdTurmaDto turmaId) {

    }

    @Override
    public AulaDetalhesDto criarAula(IdTurmaDto turmaId, NovaAulaDto novaAulaDto) {
        return null;
    }

    @Override
    public void apagarAula(IdTurmaDto turmaId, LocalDateTime dataOcorreu) {

    }

    @Override
    public List<AvaliacaoDetalhesDto> getAvaliacoesByAula(IdTurmaDto turmaId, LocalDateTime dataOcorreu) {
        return List.of();
    }

    @Override
    public List<AvaliacaoDetalhesDto> getAvaliacoesByAtividade(IdTurmaDto turmaId, Long atividadeId) {
        return List.of();
    }

    @Override
    public List<AvaliacaoDetalhesDto> getAvaliacoesAulasByAluno(IdTurmaDto turmaId, Long matricula) {
        return List.of();
    }

    @Override
    public List<AvaliacaoDetalhesDto> getAvaliacoesAtividadesByAluno(IdTurmaDto turmaId, Long matricula) {
        return List.of();
    }
}
