package com.gestao.feedback_academico.domain.entity;

public enum UserRole {
    ADMIN("ADMIN"),
    ALUNO("ALUNO"),
    PROFESSOR("PROFESSOR");

    private String role;


    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
