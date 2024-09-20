package com.gestao.feedback_academico.interfaces.dto.detalhes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalhesAtividadeDto {

    private Long id;
    private Long criadorId;
    private String nome;
    private String descricao;
    private Integer peso;
    private Boolean disponivel;
}

