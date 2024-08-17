package com.gestao.feedback_academico.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Aluno_matriculado", uniqueConstraints = @UniqueConstraint(columnNames = {"fk_aluno", "semestre", "ano"}))
public class AlunoMatriculado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_aluno", nullable = false)
    private User aluno;

    @ManyToOne
    @JoinColumn(name = "fk_turma", nullable = false)
    private Turma turma;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "ano", nullable = false)
    private Integer ano;
}

