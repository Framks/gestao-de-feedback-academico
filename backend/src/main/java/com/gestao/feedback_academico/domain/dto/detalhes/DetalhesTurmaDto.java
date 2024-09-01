package com.gestao.feedback_academico.domain.dto.detalhes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesTurmaDto {

    private Long id;
    private Long professorId;
    private String codigo;
    private String disciplina;
    private Integer semestre;
    private Integer ano;
}
