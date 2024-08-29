package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.entity.Atividade;

import java.util.List;

public interface AtividadeService {
    void criar(CriarAtividadeDto atividade);
    DetalhesAtividadeDto buscarPorId(Long id);
    List<DetalhesAtividadeDto> listar();
    void remover(Long id);
    void atualizar(Long id, Atividade atividade);
}
