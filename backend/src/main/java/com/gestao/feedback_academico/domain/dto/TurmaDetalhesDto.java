package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TurmaDetalhesDto(
        @NotBlank(message = "Nome da turma não pode ser vazio.")
        @Size(max = 255, message = "Nome da turma não pode ter mais que 255 caracteres.")
        String nome,

        @NotBlank(message = "Código da turma não pode ser vazio.")
        @Size(max = 255, message = "Código da turma não pode ter mais que 255 caracteres.")
        String codigo,

        @NotNull(message = "Semestre da turma não pode ser nulo.")
        @Positive(message = "Semestre da turma deve ser um número positivo.")
        Integer semestre
) {}
