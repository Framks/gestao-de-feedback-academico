package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record CriarAulaDto(
        @NotNull(message = "O ID da turma não pode ser nulo.")
        Long turmaId,

        @NotNull(message = "A data em que a aula ocorreu não pode ser nula.")
        Date dataOcorreu,

        @Size(max = 300, message = "A descrição da aula não pode ter mais que 300 caracteres.")
        String descricao
) {}
