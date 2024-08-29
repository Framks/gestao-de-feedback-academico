package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.Turma;
import com.gestao.feedback_academico.domain.usecase.TurmaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
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
    public List<DetalhesTurmaDto> listar() {
        return List.of();
    }

    @Override
    public void inserirAluno(Long IdTurma, Long IdAluno) {

    }

    @Override
    public void removerAluno(Long IdTurma, Long IdAluno) {

    }

    @Override
    public void disponibilizarAula(Long IdTurma, Long IdAula) {

    }

    @Override
    public void disponibilizarAtividade(Long IdTurma, Long IdAtividade) {

    }

    @Override
    public List<DetalhesUsuarioDto> listarAlunos() {
        return List.of();
    }
}
