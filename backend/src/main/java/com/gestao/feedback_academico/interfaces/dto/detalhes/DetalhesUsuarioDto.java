package com.gestao.feedback_academico.interfaces.dto.detalhes;

import com.gestao.feedback_academico.domain.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesUsuarioDto {

    private Long id;
    private UserRole role;
    private String primeiroNome;
    private String segundoNome;
    private String email;
    private Integer matricula;
    private String linkTelegram;
}