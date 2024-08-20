package com.gestao.feedback_academico.domain.repository;

import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<User, Long> {

    Optional<List<User>> findAllByRole(UserRole usr_role);

    Optional<User> findByEmail(String email);
}
