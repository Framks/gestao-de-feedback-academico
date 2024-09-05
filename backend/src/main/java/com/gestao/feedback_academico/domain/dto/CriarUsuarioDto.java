package com.gestao.feedback_academico.domain.dto;

import com.gestao.feedback_academico.domain.entity.UserRole;
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
public class CriarUsuarioDto {
        @NotNull(message = "O papel do usuário não pode ser nulo.")
        private UserRole role;

        @NotBlank(message = "O primeiro nome não pode ser vazio.")
        @Size(max = 100, message = "O primeiro nome não pode ter mais que 100 caracteres.")
        String primeiroNome;

        @NotBlank(message = "O sobrenome não pode ser vazio.")
        @Size(max = 100, message = "O sobrenome não pode ter mais que 100 caracteres.")
        private String segundoNome;

        @NotBlank(message = "O email não pode ser vazio.")
        @Size(max = 100, message = "O email não pode ter mais que 100 caracteres.")
        private String email;

        @NotBlank(message = "A senha não pode ser vazia.")
        @Size(max = 256, message = "A senha não pode ter mais que 256 caracteres.")
        private String senha;

        @Size(max = 200, message = "O link do Telegram não pode ter mais que 200 caracteres.")
        private String linkTelegram;

        private Integer matricula;
}

