package com.gestao.feedback_academico.controller.log_messages;

public enum AlunoLogMessages {

    AVALIACAO_ATIVIDADE_REALIZADA("Avaliação da atividade realizada. Atividade ID: {}"),
    AVALIACAO_AULA_REALIZADA("Avaliação da aula realizada. Aula ID: {}, Turma ID: {}"),
    AULAS_REQUISITADAS_TURMA("Aulas requisitadas para a turma ID: {}"),
    AULAS_AVALIADAS_REQUISITADAS("Aulas avaliadas requisitadas para o aluno ID: {}"),
    ATIVIDADES_TURMA_REQUISITADAS("Atividades requisitadas para a turma ID: {}"),
    ATIVIDADES_AVALIADAS_REQUISITADAS("Atividades avaliadas requisitadas para o aluno ID: {}"),
    AULAS_RECUPERADAS_TURMA("Aulas recuperadas para a turma ID: {}"),
    ATIVIDADES_TURMA_RECUPERADAS("Atividades recuperadas para a turma ID: {}"),
    AULAS_AVALIADAS_RECUPERADAS("Aulas avaliadas recuperadas para o aluno ID: {}"),
    ATIVIDADES_AVALIADAS_RECUPERADAS("Atividades avaliadas recuperadas para o aluno ID: {}");


    private final String message;

    AlunoLogMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
