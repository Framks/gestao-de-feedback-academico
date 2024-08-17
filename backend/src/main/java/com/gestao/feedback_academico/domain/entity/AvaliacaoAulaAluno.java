package com.gestao.feedback_academico.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Avaliacao_aula_aluno", uniqueConstraints = @UniqueConstraint(columnNames = {"fk_aula", "fk_aluno_matriculado"}))
public class AvaliacaoAulaAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_aula", nullable = false)
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "fk_aluno_matriculado", nullable = false)
    private AlunoMatriculado alunoMatriculado;

    @Column(name = "data_avaliacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAvaliacao;

    @Column(name = "nota", nullable = false)
    private Integer nota;

    @Column(name = "descricao", length = 300)
    private String descricao;
}
