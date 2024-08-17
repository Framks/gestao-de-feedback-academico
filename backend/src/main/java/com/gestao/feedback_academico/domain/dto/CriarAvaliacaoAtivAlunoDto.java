package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record CriarAvaliacaoAtivAlunoDto(
        @NotNull(message = "O ID da atividade disponibilizada não pode ser nulo.") Long atividadeDisponibilizadaId,

        @NotNull(message = "O ID do aluno não pode ser nulo.") Long alunoId,

        @NotNull(message = "A data da avaliação não pode ser nula.") Date dataAvaliacao,

        @NotNull(message = "A nota da avaliação não pode ser nula.") Integer nota,

        @Size(max = 300, message = "A descrição da avaliação não pode ter mais que 300 caracteres.") String descricao
) {}
