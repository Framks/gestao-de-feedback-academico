package com.gestao.feedback_academico.domain.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record NovaAvaliacaoDto(
        @NotBlank(message = "Descrição da avaliação não pode ser vazia.")
        @Size(max = 255, message = "Descrição da avaliação não pode ter mais que 255 caracteres.")
        String descricao,

        @NotNull(message = "Data da avaliação não pode ser nula.")
        LocalDateTime data,

        @NotNull(message = "Nota da avaliação não pode ser nula.")
        @Min(value = 0, message = "Nota da avaliação deve ser no mínimo 0.")
        @Max(value = 10, message = "Nota da avaliação deve ser no máximo 10.")
        Integer nota,

        @NotNull(message = "ID do aluno não pode ser nulo.")
        @Positive(message = "ID do aluno deve ser um número positivo.")
        Long alunoId,

        @NotNull(message = "ID da aula não pode ser nulo.")
        @Positive(message = "ID da aula deve ser um número positivo.")
        Long aulaId,

        @NotNull(message = "ID da atividade não pode ser nulo.")
        @Positive(message = "ID da atividade deve ser um número positivo.")
        Long atividadeId
) {}