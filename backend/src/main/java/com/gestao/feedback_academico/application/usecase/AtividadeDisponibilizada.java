package com.gestao.feedback_academico.application.usecase;

import com.gestao.feedback_academico.interfaces.dto.CriarAtivDispTurmasDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAtivDispTurmasDto;

import java.util.Date;

public interface AtividadeDisponibilizada {
    DetalhesAtivDispTurmasDto disponibilizar(CriarAtivDispTurmasDto criarAtivDispTurmasDto);
    DetalhesAtivDispTurmasDto auterarDataEntrega(Date dataEntrega);

}
