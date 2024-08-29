package com.gestao.feedback_academico.domain.repository;

import com.gestao.feedback_academico.domain.entity.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aula, Long> {
}
