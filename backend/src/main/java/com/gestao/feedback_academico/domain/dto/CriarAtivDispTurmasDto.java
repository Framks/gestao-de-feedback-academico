package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CriarAtivDispTurmasDto(
        @NotNull(message = "O ID da turma não pode ser nulo.") Long turmaId,

        @NotNull(message = "O ID da atividade não pode ser nulo.") Long atividadeId,

        @NotNull(message = "A data de disponibilização não pode ser nula.") Date dataDisponibilizada,

        @NotNull(message = "A data limite para avaliação não pode ser nula.") Date dataLimiteAvaliacao
) {}
