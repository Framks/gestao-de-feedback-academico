package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record NovaAulaDto(
        @NotNull(message = "Data da ocorrência da aula não pode ser nula.")
        LocalDateTime dataOcorreu,

        @NotNull(message = "Data final para a avaliação não pode ser nula.")
        LocalDateTime dataFinalAvaliada,

        @NotNull(message = "ID da turma não pode ser nulo.")
        @Positive(message = "ID da turma deve ser um número positivo.")
        Long turmaId
) {}
