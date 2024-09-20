package com.gestao.feedback_academico.application.usecase;

import com.gestao.feedback_academico.interfaces.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.entity.Atividade;

import java.util.List;

public interface AtividadeService {
    DetalhesAtividadeDto criar(CriarAtividadeDto atividade);
    DetalhesAtividadeDto buscarPorId(Long id);
    List<DetalhesAtividadeDto> listar();
    void remover(Long id);
    void atualizar(Long id, Atividade atividade);

}
