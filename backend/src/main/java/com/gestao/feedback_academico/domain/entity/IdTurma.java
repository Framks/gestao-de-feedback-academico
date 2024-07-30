package com.gestao.feedback_academico.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IdTurma implements Serializable {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private Integer semestre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdTurma turmaId = (IdTurma) o;
        return Objects.equals(nome, turmaId.nome) &&
                Objects.equals(codigo, turmaId.codigo) &&
                Objects.equals(semestre, turmaId.semestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, semestre);
    }
}
