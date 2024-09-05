package com.gestao.feedback_academico.domain.repository;

import com.gestao.feedback_academico.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
