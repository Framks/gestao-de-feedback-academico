package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record IdTurmaDto(

        @NotBlank(message = "O código da turma não pode ser vazio.")
        @Size(max = 50, message = "O código da turma não pode ter mais de 50 caracteres.")
        String codigo,

        @NotBlank(message = "A disciplina não pode ser vazia.")
        @Size(max = 100, message = "A disciplina não pode ter mais de 100 caracteres.")
        String disciplina,

        @NotNull(message = "O semestre não pode ser nulo.")
        Integer semestre,

        @NotNull(message = "O ano não pode ser nulo.")
        Integer ano
) {}