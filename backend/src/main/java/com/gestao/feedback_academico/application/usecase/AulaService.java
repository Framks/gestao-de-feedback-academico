package com.gestao.feedback_academico.application.usecase;

import com.gestao.feedback_academico.interfaces.dto.CriarAulaDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAulaDto;

import java.util.List;

public interface AulaService {

    DetalhesAulaDto criar(CriarAulaDto aula);
    void remover(Long id);
    DetalhesAulaDto buscarPorId(Long id);
    List<DetalhesAulaDto> listar();
    DetalhesAulaDto atualizar(Long Id, CriarAulaDto updateAula); // tipo de aula tem que ser mudado para um update aula
}
