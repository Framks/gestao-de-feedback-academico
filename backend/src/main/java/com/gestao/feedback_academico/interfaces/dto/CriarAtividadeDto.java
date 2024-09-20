package com.gestao.feedback_academico.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriarAtividadeDto {

        @NotNull(message = "O ID do criador não pode ser nulo.")
        private Long criadorId;

        @NotBlank(message = "O nome da atividade não pode ser vazio.")
        @Size(max = 100, message = "O nome da atividade não pode ter mais que 100 caracteres.")
        private String nome;

        @Size(max = 300, message = "A descrição da atividade não pode ter mais que 300 caracteres.")
        private String descricao;

        @NotNull(message = "A disponibilidade da atividade deve ser especificada.")
        private Boolean disponivel;

        private Integer peso;
}