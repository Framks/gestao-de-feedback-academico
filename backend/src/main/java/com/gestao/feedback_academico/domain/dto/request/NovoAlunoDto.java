package com.gestao.feedback_academico.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NovoAlunoDto(
        @NotBlank(message = "Login do aluno não pode ser vazio.")
        @Size(max = 255, message = "Login do aluno não pode ter mais que 255 caracteres.")
        String login,

        @NotBlank(message = "Senha do aluno não pode ser vazia.")
        @Size(max = 255, message = "Senha do aluno não pode ter mais que 255 caracteres.")
        String senha,

        @NotBlank(message = "Primeiro nome do aluno não pode ser vazio.")
        @Size(max = 255, message = "Primeiro nome do aluno não pode ter mais que 255 caracteres.")
        String primeiroNome,

        @NotBlank(message = "Segundo nome do aluno não pode ser vazio.")
        @Size(max = 255, message = "Segundo nome do aluno não pode ter mais que 255 caracteres.")
        String segundoNome,

        @NotBlank(message = "Telegram do aluno não pode ser vazio.")
        @Size(max = 255, message = "Telegram do aluno não pode ter mais que 255 caracteres.")
        String telegram
) {}
