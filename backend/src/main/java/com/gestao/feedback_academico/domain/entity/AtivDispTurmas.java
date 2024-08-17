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
@Table(name = "Ativ_disp_turmas", uniqueConstraints = @UniqueConstraint(columnNames = {"fk_turma", "fk_atividade"}))
public class AtivDispTurmas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_turma", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "fk_atividade", nullable = false)
    private Atividade atividade;

    @Column(name = "data_disponibilizada", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDisponibilizada;

    @Column(name = "data_limite_avaliacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataLimiteAvaliacao;
}
