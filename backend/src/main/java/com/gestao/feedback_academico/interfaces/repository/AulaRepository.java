package com.gestao.feedback_academico.interfaces.repository;

import com.gestao.feedback_academico.domain.entity.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

}
