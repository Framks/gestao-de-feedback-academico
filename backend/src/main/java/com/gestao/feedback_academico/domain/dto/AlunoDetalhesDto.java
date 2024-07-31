package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AlunoDetalhesDto(
        UUID id,
        @NotBlank(message = "Login do aluno não pode ser vazio.")
        @Size(max = 255, message = "Login do aluno não pode ter mais que 255 caracteres.")
        String login,

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
