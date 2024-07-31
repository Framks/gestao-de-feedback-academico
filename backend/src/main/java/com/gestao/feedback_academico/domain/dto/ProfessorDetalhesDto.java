package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ProfessorDetalhesDto(
        UUID id,
        @NotBlank(message = "Login do professor não pode ser vazio.")
        @Size(max = 255, message = "Login do professor não pode ter mais que 255 caracteres.")
        String login,

        @NotBlank(message = "Primeiro nome do professor não pode ser vazio.")
        @Size(max = 255, message = "Primeiro nome do professor não pode ter mais que 255 caracteres.")
        String primeiroNome,

        @NotBlank(message = "Segundo nome do professor não pode ser vazio.")
        @Size(max = 255, message = "Segundo nome do professor não pode ter mais que 255 caracteres.")
        String segundoNome
) {}
