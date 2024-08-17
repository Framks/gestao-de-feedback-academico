package com.gestao.feedback_academico.domain.dto.detalhes;

public record DetalhesAlunoMatriculadoDto(
        Long id,
        Long alunoId,
        Long turmaId,
        Integer semestre,
        Integer ano
) {}