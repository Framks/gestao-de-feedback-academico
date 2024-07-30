package com.gestao.feedback_academico.controller.log_messages;

public enum AdminLogMessages {
    PROFESSOR_CRIADO("Professor criado com sucesso. Professor ID: {}"),
    ADMIN_CRIADO("Admin criado com sucesso. Admin ID: {}"),
    ATIVIDADE_CADASTRADA("Atividade cadastrada com sucesso. Atividade ID: {}"),
    USUARIOS_LISTADOS("Lista de todos os usuários solicitada."),
    USUARIO_APAGADO("Usuário apagado com sucesso. Usuário ID: {}"),
    PROFESSORES_LISTADOS("Professores listados com sucesso."),
    PROFESSOR_DETALHES("Detalhes do professor requisitados. Matrícula: {}"),
    ADMINS_LISTADOS("Admins listados com sucesso.");

    private final String message;

    AdminLogMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
