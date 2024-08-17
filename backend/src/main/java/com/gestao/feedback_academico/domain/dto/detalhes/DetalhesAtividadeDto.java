package com.gestao.feedback_academico.domain.dto.detalhes;

public record DetalhesAtividadeDto(
        Long id,
        Long criadorId,
        String nome,
        String descricao,
        Integer peso,
        Boolean disponivel
) {}
