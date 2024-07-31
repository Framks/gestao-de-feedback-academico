package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AvaliacaoAulaDto(
        @NotNull(message = "Aula ID não pode ser nulo.")
        @Positive(message = "Aula ID deve ser um número positivo.")
        Long aulaId,

        @NotNull(message = "Turma ID não pode ser nulo.")
        @Positive(message = "Turma ID deve ser um número positivo.")
        Long turmaId,

        @NotNull(message = "Nota não pode ser nula.")
        @Positive(message = "Nota deve ser um número positivo.")
        Integer nota,

        @NotNull(message = "Comentário não pode ser nulo.")
        String comentario
) {}
