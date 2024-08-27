package com.gestao.feedback_academico.domain.repository;

import com.gestao.feedback_academico.domain.entity.AvaliacaoAulaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoAulaAlunoRepository extends JpaRepository<AvaliacaoAulaAluno, Long> {


}
