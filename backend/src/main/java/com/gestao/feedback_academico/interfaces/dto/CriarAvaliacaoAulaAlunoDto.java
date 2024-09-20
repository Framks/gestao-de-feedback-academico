package com.gestao.feedback_academico.interfaces.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriarAvaliacaoAulaAlunoDto {

    @NotNull(message = "O ID da aula não pode ser nulo.")
    private Long aulaId;

    @NotNull(message = "O ID do aluno matriculado não pode ser nulo.")
    private Long alunoMatriculadoId;

    @NotNull(message = "A data da avaliação não pode ser nula.")
    private Date dataAvaliacao;

    @NotNull(message = "A nota da avaliação não pode ser nula.")
    private Integer nota;

    @Size(max = 300, message = "A descrição da avaliação não pode ter mais que 300 caracteres.")
    private String descricao;
}
