package com.gestao.feedback_academico.domain.dto.detalhes;

import java.util.Date;

public record DetalhesAulaDto(
        Long id,
        Long turmaId,
        Date dataOcorreu,
        String descricao
) {}
