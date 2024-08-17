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

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Atividade", uniqueConstraints = @UniqueConstraint(columnNames = "uk_nome"))
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_criador", nullable = false)
    private User criador;

    @Column(name = "uk_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 300)
    private String descricao;

    @Column(name = "peso", nullable = false)
    private Integer peso = 1;

    @Column(name = "disponivel", nullable = false)
    private Boolean disponivel;
}

