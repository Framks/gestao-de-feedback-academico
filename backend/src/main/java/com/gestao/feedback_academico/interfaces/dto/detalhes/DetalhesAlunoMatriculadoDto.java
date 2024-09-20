package com.gestao.feedback_academico.interfaces.dto.detalhes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesAlunoMatriculadoDto {

    private Long id;
    private Long alunoId;
    private Long turmaId;
    private Integer semestre;
    private Integer ano;
}
