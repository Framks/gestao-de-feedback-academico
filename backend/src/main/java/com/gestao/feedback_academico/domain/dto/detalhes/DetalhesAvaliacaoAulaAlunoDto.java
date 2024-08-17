package com.gestao.feedback_academico.domain.dto.detalhes;

import java.util.Date;

public record DetalhesAvaliacaoAulaAlunoDto(
        Long id,
        Long aulaId,
        Long alunoMatriculadoId,
        Date dataAvaliacao,
        Integer nota,
        String descricao
) {}
