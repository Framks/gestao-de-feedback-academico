package com.gestao.feedback_academico.interfaces.repository;

import com.gestao.feedback_academico.domain.entity.AtivDispTurmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivDispTurmasRepository extends JpaRepository<AtivDispTurmas, Long> {
}