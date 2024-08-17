package com.gestao.feedback_academico.domain.dto.detalhes;

public record DetalhesTurmaDto(
        Long id,
        Long professorId,
        String codigo,
        String disciplina,
        Integer semestre,
        Integer ano
) {}

