package com.gestao.feedback_academico.interfaces.repository;

import com.gestao.feedback_academico.domain.entity.AvaliacaoAtivAluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoAtivAlunoRepository extends JpaRepository<AvaliacaoAtivAluno, Long> {
}