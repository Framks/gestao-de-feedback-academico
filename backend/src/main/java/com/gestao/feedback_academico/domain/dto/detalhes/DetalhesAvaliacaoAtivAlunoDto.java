package com.gestao.feedback_academico.domain.dto.detalhes;

import java.util.Date;

public record DetalhesAvaliacaoAtivAlunoDto(
        Long id,
        Long atividadeDisponibilizadaId,
        Long alunoId,
        Date dataAvaliacao,
        Integer nota,
        String descricao
) {}
