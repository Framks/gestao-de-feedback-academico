package com.gestao.feedback_academico.interfaces.dto.detalhes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesAvaliacaoAulaAlunoDto {

    private Long id;
    private Long aulaId;
    private Long alunoMatriculadoId;
    private Date dataAvaliacao;
    private Integer nota;
    private String descricao;
}
