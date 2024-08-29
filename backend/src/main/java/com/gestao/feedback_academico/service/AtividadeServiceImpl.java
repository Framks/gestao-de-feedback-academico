package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.entity.Atividade;
import com.gestao.feedback_academico.domain.usecase.AtividadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AtividadeServiceImpl implements AtividadeService {
    @Override
    public void criar(CriarAtividadeDto atividade) {

    }

    @Override
    public DetalhesAtividadeDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<DetalhesAtividadeDto> listar() {
        return List.of();
    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public void atualizar(Long id, Atividade atividade) {

    }

}
