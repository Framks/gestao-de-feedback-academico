package com.gestao.feedback_academico.domain.dto.detalhes;

import com.gestao.feedback_academico.domain.entity.UserRole;

public record DetalhesUsuarioDto(
        Long id,
        UserRole usrRole,
        String pNome,
        String sNome,
        String email,
        Integer matricula,
        String linkTelegram
) {}
