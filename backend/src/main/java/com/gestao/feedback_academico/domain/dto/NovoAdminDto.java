package com.gestao.feedback_academico.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NovoAdminDto(
        @NotBlank(message = "Login do admin não pode ser vazio.")
        @Size(max = 255, message = "Login do admin não pode ter mais que 255 caracteres.")
        String login,

        @NotBlank(message = "Senha do admin não pode ser vazia.")
        @Size(max = 255, message = "Senha do admin não pode ter mais que 255 caracteres.")
        String senha,

        @NotBlank(message = "Primeiro nome do admin não pode ser vazio.")
        @Size(max = 255, message = "Primeiro nome do admin não pode ter mais que 255 caracteres.")
        String primeiroNome,

        @NotBlank(message = "Segundo nome do admin não pode ser vazio.")
        @Size(max = 255, message = "Segundo nome do admin não pode ter mais que 255 caracteres.")
        String segundoNome
) {}
