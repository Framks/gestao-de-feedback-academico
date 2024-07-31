package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AvaliacaoAtividadeDto(
        @NotNull(message = "Atividade ID não pode ser nulo.")
        @Positive(message = "Atividade ID deve ser um número positivo.")
        Long atividadeId,

        @NotNull(message = "Nota não pode ser nula.")
        @Positive(message = "Nota deve ser um número positivo.")
        Integer nota,

        @NotNull(message = "Comentário não pode ser nulo.")
        String comentario
) {}
