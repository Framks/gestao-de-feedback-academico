package com.gestao.feedback_academico.domain.dto;

import com.gestao.feedback_academico.domain.entity.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarUsuarioDto(
        @NotNull(message = "O papel do usuário não pode ser nulo.")
        UserRole usrRole,

        @NotBlank(message = "O primeiro nome não pode ser vazio.")
        @Size(max = 100, message = "O primeiro nome não pode ter mais que 100 caracteres.")
        String pNome,

        @NotBlank(message = "O sobrenome não pode ser vazio.")
        @Size(max = 100, message = "O sobrenome não pode ter mais que 100 caracteres.")
        String sNome,

        @NotBlank(message = "O email não pode ser vazio.")
        @Size(max = 100, message = "O email não pode ter mais que 100 caracteres.")
        String email,

        @NotBlank(message = "A senha não pode ser vazia.")
        @Size(max = 256, message = "A senha não pode ter mais que 256 caracteres.")
        String senha,

        @Size(max = 200, message = "O link do Telegram não pode ter mais que 200 caracteres.")
        String linkTelegram,

        Integer matricula
) {}

