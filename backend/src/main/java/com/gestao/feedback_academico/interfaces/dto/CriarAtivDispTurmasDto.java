package com.gestao.feedback_academico.interfaces.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriarAtivDispTurmasDto {

    @NotNull(message = "O ID da turma não pode ser nulo.")
    private Long turmaId;

    @NotNull(message = "O ID da atividade não pode ser nulo.")
    private Long atividadeId;

    @NotNull(message = "A data de disponibilização não pode ser nula.")
    private Date dataDisponibilizada;

    @NotNull(message = "A data limite para avaliação não pode ser nula.")
    private Date dataLimiteAvaliacao;
}
