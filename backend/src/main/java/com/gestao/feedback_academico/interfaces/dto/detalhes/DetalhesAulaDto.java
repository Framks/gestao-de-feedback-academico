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
public class DetalhesAulaDto {

    private Long id;
    private Long turmaId;
    private Date dataOcorreu;
    private String descricao;
}
