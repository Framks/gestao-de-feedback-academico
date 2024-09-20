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
public class CriarAulaDto {

        @NotNull(message = "O ID da turma não pode ser nulo.")
        private Long turmaId;

        @NotNull(message = "A data em que a aula ocorreu não pode ser nula.")
        private Date dataOcorreu;

        @Size(max = 300, message = "A descrição da aula não pode ter mais que 300 caracteres.")
        private String descricao;
}