package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.usecase.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {


    @Override
    public void criar(User user) {

    }

    @Override
    public void atualizar(User user) {

    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public DetalhesUsuarioDto getAluno(Long id) {
        return null;
    }

    @Override
    public List<DetalhesUsuarioDto> getAlunos() {
        return List.of();
    }
}
