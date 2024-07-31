package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AtividadeDetalhesDto(
        UUID id,
        @NotBlank(message = "Nome da atividade não pode ser vazio.")
        @Size(max = 255, message = "Nome da atividade não pode ter mais que 255 caracteres.")
        String nome,

        @Size(max = 255, message = "Descrição da atividade não pode ter mais que 255 caracteres.")
        String descricao,

        @NotNull(message = "Disponibilidade da atividade não pode ser nula.")
        Boolean disponivel,

        @NotNull(message = "ID da turma não pode ser nulo.")
        @Positive(message = "ID da turma deve ser um número positivo.")
        Long turmaId
) {}

