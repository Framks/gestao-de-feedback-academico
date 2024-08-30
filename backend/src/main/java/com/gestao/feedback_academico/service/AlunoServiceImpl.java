package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.usecase.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoServiceImpl implements AlunoService {


    @Override
    public DetalhesUsuarioDto criar(CriarUsuarioDto user) {
        return null;
    }

    @Override
    public DetalhesUsuarioDto atualizar(CriarUsuarioDto user) {
        return null;
    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public DetalhesUsuarioDto buscarAlunoPorId(Long id) {
        return null;
    }

    @Override
    public List<DetalhesUsuarioDto> listar() {
        return List.of();
    }

}
