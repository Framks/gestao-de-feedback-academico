package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;

public record CriarAlunoMatriculadoDto(
        @NotNull(message = "O ID do aluno não pode ser nulo.") Long alunoId,

        @NotNull(message = "O ID da turma não pode ser nulo.") Long turmaId,

        @NotNull(message = "O semestre não pode ser nulo.") Integer semestre,

        @NotNull(message = "O ano não pode ser nulo.") Integer ano
) {}
