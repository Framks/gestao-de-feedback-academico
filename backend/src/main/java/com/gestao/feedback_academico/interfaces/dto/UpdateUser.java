package com.gestao.feedback_academico.interfaces.dto;

import com.gestao.feedback_academico.domain.entity.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {

    private String email;
    private Integer matricula;
    private String linkTelegram;
    private String primeiroNome;
    private UserRole role;
    private String segundoNome;
}
