package com.gestao.feedback_academico.controller.log_messages;

public enum ProfessorLogMessages {
    // Mensagens relacionadas ao ProfessorController
    ATIVIDADES_REQUISITADAS("Requisitando todas as atividades disponíveis"),
    ATIVIDADES_RECUPERADAS("Atividades recuperadas com sucesso"),
    AULAS_REQUISITADAS_TURMA("Requisitando aulas para a turma com ID {}"),
    AULAS_RECUPERADAS_TURMA("Aulas recuperadas com sucesso para a turma com ID {}"),
    ATIVIDADES_DISPONIBILIZADAS_REQUISITADAS("Requisitando atividades disponibilizadas pelo professor"),
    ATIVIDADES_DISPONIBILIZADAS_RECUPERADAS("Atividades disponibilizadas recuperadas com sucesso"),
    NOVA_ATIVIDADE_DISPONIBILIZADA("Disponibilizando nova atividade: {}"),
    ATIVIDADE_DISPONIBILIZADA_SUCESSO("Atividade disponibilizada com sucesso"),
    NOVA_TURMA_CRIADA("Criando nova turma: {}"),
    TURMA_CRIADA_SUCESSO("Turma criada com sucesso"),
    TURMA_APAGADA("Apagando turma com ID {}"),
    TURMA_APAGADA_SUCESSO("Turma apagada com sucesso"),
    NOVO_ALUNO_CRIADO("Criando novo aluno: {}"),
    ALUNO_CRIADO_SUCESSO("Aluno criado com sucesso"),
    ALUNO_APAGADO("Apagando aluno com matrícula {}"),
    ALUNO_APAGADO_SUCESSO("Aluno apagado com sucesso"),
    NOVA_AULA_CRIADA("Criando nova aula: {}"),
    AULA_CRIADA_SUCESSO("Aula criada com sucesso"),
    AULA_APAGADA("Apagando aula da turma com ID {} na data {}"),
    AULA_APAGADA_SUCESSO("Aula apagada com sucesso"),
    AVALIACOES_REQUISITADAS_AULA("Requisitando avaliações para a aula da turma com ID {} na data {}"),
    AVALIACOES_RECUPERADAS_AULA("Avaliações recuperadas com sucesso para a aula da turma com ID {} na data {}"),
    AVALIACOES_REQUISITADAS_ATIVIDADE("Requisitando avaliações para a atividade com ID {}"),
    AVALIACOES_RECUPERADAS_ATIVIDADE("Avaliações recuperadas com sucesso para a atividade com ID {}"),
    AVALIACOES_AULAS_REQUISITADAS_ALUNO("Requisitando avaliações de aulas para o aluno com ID {}"),
    AVALIACOES_AULAS_RECUPERADAS_ALUNO("Avaliações de aulas recuperadas com sucesso para o aluno com ID {}"),
    AVALIACOES_ATIVIDADES_REQUISITADAS_ALUNO("Requisitando avaliações de atividades para o aluno com ID {}"),
    AVALIACOES_ATIVIDADES_RECUPERADAS_ALUNO("Avaliações de atividades recuperadas com sucesso para o aluno com ID {}");

    private final String message;

    ProfessorLogMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
