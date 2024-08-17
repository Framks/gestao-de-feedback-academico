package com.gestao.feedback_academico.domain.dto.detalhes;

import java.util.Date;

public record DetalhesAtivDispTurmasDto(
        Long id,
        Long turmaId,
        Long atividadeId,
        Date dataDisponibilizada,
        Date dataLimiteAvaliacao
) {}