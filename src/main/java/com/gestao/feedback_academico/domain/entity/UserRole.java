package com.gestao.feedback_academico.domain.entity;

public enum UserRole {
    ADMIN("admin"),
    ALUNO("aluno"),
    PROFESSOR("professor");

    private String role;


    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
