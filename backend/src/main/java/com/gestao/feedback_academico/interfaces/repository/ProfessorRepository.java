package com.gestao.feedback_academico.interfaces.repository;

import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.role = :role")
    Optional<List<User>> findAllByRole(@Param("role") UserRole role);

    Optional<User> findByEmail(String email);
}
