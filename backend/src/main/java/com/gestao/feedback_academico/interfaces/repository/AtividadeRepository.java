package com.gestao.feedback_academico.interfaces.repository;


import com.gestao.feedback_academico.domain.entity.Atividade;
import com.gestao.feedback_academico.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    List<Atividade> findByCriador(User criador);
}
