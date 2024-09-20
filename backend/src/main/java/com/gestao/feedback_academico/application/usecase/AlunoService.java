package com.gestao.feedback_academico.application.usecase;

import com.gestao.feedback_academico.interfaces.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesUsuarioDto;

import java.util.List;

/**
 * Interface para o serviço de operações relacionadas aos alunos.
 */
public interface AlunoService {

    DetalhesUsuarioDto criar(CriarUsuarioDto user);
    DetalhesUsuarioDto atualizar(Long id, CriarUsuarioDto user);
    void remover(Long id);
    DetalhesUsuarioDto buscarAlunoPorId(Long id);
    List<DetalhesUsuarioDto> listar();

}