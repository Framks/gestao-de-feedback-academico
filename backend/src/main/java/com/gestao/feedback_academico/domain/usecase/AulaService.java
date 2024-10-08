package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.CriarAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;

import java.util.List;

public interface AulaService {

    void criar(CriarAulaDto aula);
    void remover(Long id);
    DetalhesAulaDto buscarPorId(Long id);
    List<DetalhesAulaDto> listar();
    void atualizar(Long Id, CriarAulaDto updateAula); // tipo de aula tem que ser mudado para um update aula
}
