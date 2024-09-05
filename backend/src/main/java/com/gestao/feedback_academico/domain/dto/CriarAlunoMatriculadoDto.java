package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriarAlunoMatriculadoDto {

    @NotNull(message = "O ID do aluno não pode ser nulo.")
    private Long alunoId;

    @NotNull(message = "O ID da turma não pode ser nulo.")
    private Long turmaId;

    @NotNull(message = "O semestre não pode ser nulo.")
    private Integer semestre;

    @NotNull(message = "O ano não pode ser nulo.")
    private Integer ano;
}
