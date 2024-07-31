package com.gestao.feedback_academico.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "professores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends User {

    @Id
    private Long matricula;

    public Professor(Long matricula, String login, String senha, String primeiroNome, String segundoNome, UserRole role) {
        super(login, senha, primeiroNome, segundoNome, role);
        this.matricula = matricula;
    }
}
