package com.gestao.feedback_academico.interfaces.repository;

import com.gestao.feedback_academico.domain.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
