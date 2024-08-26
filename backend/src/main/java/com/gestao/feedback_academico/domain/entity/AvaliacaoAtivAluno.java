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

import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"fk_ativ_disp_turmas", "fk_aluno"}))
public class AvaliacaoAtivAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_ativ_disp_turmas", nullable = false)
    private AtivDispTurmas atividadeDisponibilizada;

    @ManyToOne
    @JoinColumn(name = "fk_aluno", nullable = false)
    private User aluno;

    @Column(name = "data_avaliacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAvaliacao;

    @Column(nullable = false)
    private Integer nota;

    @Column(length = 300)
    private String descricao;
}
