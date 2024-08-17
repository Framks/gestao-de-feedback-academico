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
@Table(name = "Turma", uniqueConstraints = @UniqueConstraint(columnNames = {"codigo", "disciplina", "semestre", "ano"}))
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_professor", nullable = false)
    private User professor;

    @Column(name = "codigo", length = 50, nullable = false)
    private String codigo;

    @Column(name = "disciplina", length = 100, nullable = false)
    private String disciplina;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "ano", nullable = false)
    private Integer ano;
}


