package com.gestao.feedback_academico.domain.dto.detalhes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesAvaliacaoAtivAlunoDto {

    private Long id;
    private Long atividadeDisponibilizadaId;
    private Long alunoId;
    private Date dataAvaliacao;
    private Integer nota;
    private String descricao;
}
