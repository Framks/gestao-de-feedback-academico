package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record IdTurmaDto(
        @NotBlank(message = "O nome do curso não pode estar vazio")
        String nome,

        @NotBlank(message = "O código do curso não pode estar vazio")
        String codigo,

        @NotNull(message = "O semestre não pode ser nulo")
        @Positive(message = "O semestre deve ser um número positivo")
        Integer semestre
) {
}
